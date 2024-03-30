package com.rone.service.impl;

import com.rone.api.wechat.WeChatApi;
import com.rone.constant.HttpSessionAttributeConstant;
import com.rone.dao.LogonControlMapper;
import com.rone.dao.SendSmsFlowMapper;
import com.rone.dao.UserInfoMapper;
import com.rone.entity.*;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.enumeration.UserInfoTypeEnum;
import com.rone.enums.SmsTypeEnum;
import com.rone.enums.logon.LogonControlLogonStatusEnum;
import com.rone.enums.logon.LogonControlLogonTypeEnum;
import com.rone.enums.user.UserInfoStatusEnum;
import com.rone.exception.LogonException;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.exception.SessionDueException;
import com.rone.model.LogonUserInfo;
import com.rone.model.SmsAuthCode;
import com.rone.model.WeChatLogonResult;
import com.rone.qo.*;
import com.rone.service.CommonService;
import com.rone.service.SysParamService;
import com.rone.service.LogonService;
import com.rone.session.RoneSessionContext;
import com.rone.utils.date.DateUtil;
import com.rone.utils.format.CheckFormatUtil;
import com.rone.vo.UserInfoVO;
import com.rone.vo.WeChatLogonVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 登陆日志服务
 *
 * @author rone
 */
@Service
@Transactional
public class LogonServiceImpl implements LogonService {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogonServiceImpl.class);

    @Resource
    private LogonControlMapper logonControlMapper;
    @Autowired
    private WeChatApi weChatApi;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private SysParamService sysParamService;
    @Resource
    private SendSmsFlowMapper sendSmsFlowMapper;
    @Autowired
    private CommonService commonService;

    /**
     * @param weChatLogonQo
     * @return
     * @throws Exception
     */
    @Override
    public WeChatLogonVO weChatLogon(WeChatLogonQo weChatLogonQo) throws Exception {
        Integer humanVerificationMinutes = sysParamService.getSysParamIntValue(SystemParamKeyEnum.HUMAN_VERIFICATION_MINUTES);
        Integer humanVerificationTimes = sysParamService.getSysParamIntValue(SystemParamKeyEnum.HUMAN_VERIFICATION_TIMES);
        String humanVerificationShakeRange = sysParamService.getSysParamValue(SystemParamKeyEnum.HUMAN_VERIFICATION_SHAKE_RANGE);
        String jsCode = weChatLogonQo.getJsCode();
        String sessionId = weChatLogonQo.getSessionId();
        HttpSession session;
        try {
            session = RoneSessionContext.getInstance().getSession(sessionId);
        } catch (RoneException e) {
            session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        }
        if (session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO) != null) {
            LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);
            return WeChatLogonVO.logon(session.getId(), logonUserInfo.getWuiMobileNo(), String.valueOf(logonUserInfo.getUserType()), humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
        }

        WeChatLogonResult weChatLogonResult = weChatApi.login(jsCode);
        String openId = weChatLogonResult.getOpenId();
        if (StringUtils.isNotEmpty(openId)) {
            session.setAttribute(HttpSessionAttributeConstant.OPEN_ID, openId);
            session.setAttribute(HttpSessionAttributeConstant.SESSION_KEY, weChatLogonResult.getSessionKey());
            session.setAttribute(HttpSessionAttributeConstant.UNION_ID, weChatLogonResult.getUnionId());
            UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
            UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
            criteria.andWuiOpenidEqualTo(openId.trim());
            criteria.andWuiStatusNotEqualTo(UserInfoStatusEnum.UNREGISTER.getCode());
            List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoCriteria);
            if (userInfoList == null || userInfoList.isEmpty()) {
                // 新用户
                return WeChatLogonVO.noRegister(session.getId(), "", humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
            } else {
                // 用户已注册
                UserInfo userInfo = userInfoList.get(0);
                if (!UserInfoStatusEnum.NORMAL.getCode().equals(userInfo.getWuiStatus())) {
                    UserInfoStatusEnum userInfoStatus = UserInfoStatusEnum.getByCode(userInfo.getWuiStatus());
                    throw new LogonException("登陆失败，用户状态不正常" + userInfoStatus != null ? "，当前用户状态为：" + userInfoStatus.getName() : "");
                }
                // 清除旧的Token
                userInfoMapper.updateUserToken(userInfo.getWuiCustNo(), "", session.getId(), new Date(), new Date(), "");
                return WeChatLogonVO.noLogon(session.getId(), userInfo.getWuiMobileNo(), String.valueOf(userInfo.getUserType()), humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
            }
        } else {
            LOGGER.error("微信登陆出错，返回的openId为空，js_code：{}", jsCode);
            throw new LogonException("微信小程序登陆异常，请重新登陆");
        }
    }

    @Override
    public synchronized void sendSMSAuthCode(SendSMSAuthCodeQO sendSMSAuthCodeQO) throws Exception {
        String mobileNo = sendSMSAuthCodeQO.getMobileNo();
        // 验证手机号是否合规
        if (!CheckFormatUtil.isMobile(mobileNo)) {
            throw new ParamException("手机号码格式不正确！");
        }

        // 防恶意操作，毕竟每发一条短信都是钱
        // 限制IP
        int ipMinutes = 5;
        try {
            ipMinutes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ASTRICT_IP_SEND_SMS_MINUTES.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("发送短信限制规则，限制同一IP发送手机短信的时长 参数获取错误，出错信息：{}", e.getMessage(), e);
        }
        int ipTimes = 10;
        try {
            ipTimes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ASTRICT_IP_SEND_SMS_TIMES.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("发送短信限制规则，限制同一IP发送手机短信的次数 参数获取错误，出错信息：{}", e.getMessage(), e);
        }
        SendSmsFlowCriteria sendSmsFlowCriteria = new SendSmsFlowCriteria();
        // 增加了代理服务器之后获取用户ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String logonIp = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getRemoteAddr();
        }
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -ipMinutes);
        sendSmsFlowCriteria.createCriteria().andIpEqualTo(logonIp).andTimeGreaterThanOrEqualTo(now.getTime());
        long times = sendSmsFlowMapper.countByExample(sendSmsFlowCriteria);
        if (times >= ipTimes) {
            LOGGER.warn("{}地址过于频繁的请求发送验证码", logonIp);
            throw new RoneException("验证码获取过于频繁，请 " + ipMinutes + " 分钟之后再操作！");
        }
        int phoneMinutes = 1;
        try {
            phoneMinutes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ASTRICT_PHONE_NUMBER_SEND_SMS_MINUTES.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("发送短信限制规则，限制同一手机号发送手机短信的时长 参数获取错误，出错信息：{}", e.getMessage(), e);
        }
        int phoneTimes = 1;
        try {
            phoneTimes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ASTRICT_PHONE_NUMBER_SEND_SMS_TIMES.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("发送短信限制规则，限制同一手机号发送手机短信的次数 参数获取错误，出错信息：{}", e.getMessage(), e);
        }
        sendSmsFlowCriteria = new SendSmsFlowCriteria();
        now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -phoneMinutes);
        sendSmsFlowCriteria.createCriteria().andMobileNoEqualTo(mobileNo).andTimeGreaterThanOrEqualTo(now.getTime());
        times = sendSmsFlowMapper.countByExample(sendSmsFlowCriteria);
        if (times >= phoneTimes) {
            LOGGER.warn("{}手机号过于频繁的请求发送验证码", mobileNo);
            throw new RoneException("验证码获取过于频繁，请 " + phoneMinutes + " 分钟之后再操作！");
        }

        // 生成验证码
        // Integer authCode = (new Random()).nextInt(900000) + 100000;
        Integer authCode = 123456;
        SmsAuthCode smsAuthCode = new SmsAuthCode(mobileNo.trim(), authCode, new Date());
        HttpSession session = RoneSessionContext.getInstance().getSession(sendSMSAuthCodeQO.getSessionId());
        session.setAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE, smsAuthCode);

        // 发送验证码
        String message = String.format("验证码：%s，您正在操作微信小程序，5分钟内有效，请勿告知他人。如非本人操作，请忽略！", authCode);

        SendSmsFlow sendSmsFlow = new SendSmsFlow();
        sendSmsFlow.setContent(message);
        sendSmsFlow.setIp(logonIp);
        sendSmsFlow.setMobileNo(mobileNo);
        sendSmsFlow.setSmsType(SmsTypeEnum.AUTH_CODE.getCode());
        sendSmsFlow.setTime(new Date());
        sendSmsFlow.setSeq(String.valueOf(System.currentTimeMillis()));
        sendSmsFlowMapper.insert(sendSmsFlow);
    }

    /**
     * 注册
     *
     * @param registerQO
     * @throws Exception
     */
    @Override
    public UserInfoVO register(RegisterQO registerQO) throws Exception {
        // 校验参数
        String mobileNo = registerQO.getMobileNo();
        String smsAuthCode = registerQO.getSmsAuthCode();
        if (StringUtils.isEmpty(mobileNo) || StringUtils.isEmpty(smsAuthCode)) {
            throw new ParamException("请正确输入页面内容！");
        }
        if (!CheckFormatUtil.isMobile(mobileNo)) {
            throw new ParamException("手机号码格式不正确！");
        }
        HttpSession session;
        try {
            session = RoneSessionContext.getInstance().getSession(registerQO.getSessionId());
        } catch (RoneException e) {
            throw new SessionDueException("注册失败，长时间未完成注册操作！");
        }
        String openId = String.valueOf(session.getAttribute(HttpSessionAttributeConstant.OPEN_ID));
        if (StringUtils.isEmpty(openId) || "null".equals(openId)) {
            throw new SessionDueException("注册失败，长时间未完成注册操作！");
        }

        // 验证短信验证码
        SmsAuthCode smsAuthCodeObject = (SmsAuthCode) session.getAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);
        if (smsAuthCodeObject == null) {
            throw new LogonException("注册失败，未发送手机验证码！");
        }
        if (!mobileNo.trim().equals(smsAuthCodeObject.getMobileNo())) {
            throw new LogonException("注册失败，手机号码与发送验证码的手机号码不一致！");
        }
        if (smsAuthCodeObject.checkTimeOut(new Date())) {
            throw new LogonException("注册失败，验证码已过期！");
        }
        if (!smsAuthCode.equals(String.valueOf(smsAuthCodeObject.getCode()))) {
            throw new LogonException("注册失败，手机验证码错误！");
        }
        session.removeAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);

        UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
        UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
        criteria.andWuiOpenidEqualTo(openId)
                .andWuiStatusEqualTo(UserInfoStatusEnum.NORMAL.getCode());
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoCriteria);
        if (!userInfoList.isEmpty()) {
            throw new RoneException("该微信已注册，请直接登录！");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setWuiOpenid(openId);
        userInfo.setWuiMobileNo(mobileNo);
        userInfo.setWuiStatus(UserInfoStatusEnum.NORMAL.getCode());
        userInfo.setWuiRegisterTime(new Date());
        userInfo.setWuiUnionid(String.valueOf(session.getAttribute(HttpSessionAttributeConstant.UNION_ID)));
        userInfo.setUserType(UserInfoTypeEnum.VIP.getCode());
        userInfoMapper.insertSelective(userInfo);

        // 登陆日志
        this.logonSuccessLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.SUCCESS);

        return new UserInfoVO(userInfo.getWuiMobileNo(), String.valueOf(userInfo.getUserType()));
    }

    @Override
    public UserInfoVO logon(LogonQO logonQO) throws Exception {
        String mobileNo = logonQO.getMobileNo();
        String smsAuthCode = logonQO.getSmsAuthCode();
        if (StringUtils.isEmpty(mobileNo) || StringUtils.isEmpty(smsAuthCode)) {
            throw new ParamException("请填写页面所有内容！");
        }
        // 验证手机号是否合规
        if (!CheckFormatUtil.isMobile(mobileNo)) {
            throw new ParamException("手机号码格式不正确！");
        }
        HttpSession session = RoneSessionContext.getInstance().getSession(logonQO.getSessionId());
        String openId = String.valueOf(session.getAttribute(HttpSessionAttributeConstant.OPEN_ID));

        int astrictLogonTimesPerMinute;
        try {
            astrictLogonTimesPerMinute = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ASTRICT_LOGON_TIMES_PER_MINUTE.getCode()));
        } catch (NumberFormatException e) {
            astrictLogonTimesPerMinute = Integer.parseInt(SystemParamKeyEnum.ASTRICT_LOGON_TIMES_PER_MINUTE.getDefaultValue());
            LOGGER.warn("限制登录频率，参数({})获取错误，出错信息：{}", SystemParamKeyEnum.ASTRICT_LOGON_TIMES_PER_MINUTE.getCode(), e.getMessage(), e);
        }
        LogonControlCriteria logonControlCriteria = new LogonControlCriteria();
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -1);
        logonControlCriteria.createCriteria().andWlcSessionidEqualTo(logonQO.getSessionId()).andWlcLogonTimeGreaterThanOrEqualTo(now.getTime());
        long logonTimes = logonControlMapper.countByExample(logonControlCriteria);
        if (logonTimes >= astrictLogonTimesPerMinute) {
            throw new LogonException("登陆失败，请求次数过多请稍后再试！。");
        }

        // 获取客户信息
        UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
        UserInfoCriteria.Criteria criteria = userInfoCriteria.createCriteria();
        criteria.andWuiOpenidEqualTo(openId.trim());
        criteria.andWuiStatusNotEqualTo(UserInfoStatusEnum.UNREGISTER.getCode());
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoCriteria);
        if (userInfoList == null || userInfoList.isEmpty()) {
            this.logonFailLog(session, null, openId, LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.FAIL, "登陆失败，原因：用户不存在。");
            throw new LogonException("登陆失败，原因：用户不存在。");
        }
        // 用户已注册
        UserInfo userInfo = userInfoList.get(0);
        if (!UserInfoStatusEnum.NORMAL.getCode().equals(userInfo.getWuiStatus())) {
            UserInfoStatusEnum userInfoStatus = UserInfoStatusEnum.getByCode(userInfo.getWuiStatus());
            String failMessage = "登陆失败，用户状态不正常" + userInfoStatus != null ? "，当前用户状态为：" + userInfoStatus.getName() : "";
            this.logonFailLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.FAIL, failMessage);
            throw new LogonException(failMessage);
        }

        // 验证手机号是否是注册时的手机
        if (!mobileNo.trim().equals(userInfo.getWuiMobileNo().trim())) {
            this.logonFailLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.FAIL, "登陆失败，手机号码非注册时的手机号码！");
            throw new LogonException("登陆失败，手机号码非注册时的手机号码！");
        }

        // 验证短信验证码
        SmsAuthCode smsAuthCodeObject = (SmsAuthCode) session.getAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);
        if (smsAuthCodeObject == null) {
            throw new LogonException("登陆失败，未发送手机验证码！");
        }
        if (!mobileNo.trim().equals(smsAuthCodeObject.getMobileNo().trim())) {
            this.logonFailLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.FAIL, "登陆失败，手机号码与发送验证码的手机号码不一致！");
            throw new LogonException("登陆失败，手机号码与发送验证码的手机号码不一致！");
        }
        if (smsAuthCodeObject.checkTimeOut(new Date())) {
            throw new LogonException("登陆失败，验证码已过期！");
        }
        if (!smsAuthCode.equals(smsAuthCodeObject.getCode().toString())) {
            this.logonFailLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.FAIL, "登陆失败，手机验证码错误！");
            throw new LogonException("登陆失败，手机验证码错误！");
        }
        session.removeAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);

        // 登陆日志
        this.logonSuccessLog(session, userInfo.getWuiCustNo(), userInfo.getWuiOpenid(), LogonControlLogonTypeEnum.SMS_AUTH_CODE, LogonControlLogonStatusEnum.SUCCESS);

        session.setAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO, new LogonUserInfo(userInfo, commonService.getWeChatUserEncryptKey(openId, String.valueOf(session.getAttribute(HttpSessionAttributeConstant.SESSION_KEY)))));

        return new UserInfoVO(userInfo.getWuiMobileNo(), String.valueOf(userInfo.getUserType()));
    }

    @Override
    public void logonOut(CommonQO qo) throws Exception {
        HttpSession session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
        LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);
        session.removeAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);
        session.removeAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);

        // 设置token无效
        userInfoMapper.updateUserToken(logonUserInfo.getWuiCustNo(), "", qo.getSessionId(), new Date(), new Date(), "");
    }

    /**
     * 登陆成功登陆日志
     *
     * @param session
     * @param custNo
     * @param openId
     * @param logonType
     * @param logonStatus
     */
    private void logonSuccessLog(HttpSession session, String custNo, String openId, LogonControlLogonTypeEnum logonType, LogonControlLogonStatusEnum logonStatus) {
        this.logonFailLog(session, custNo, openId, logonType, logonStatus, null);
    }

    /**
     * 新增一条登陆日志
     *
     * @param session
     * @param custNo
     * @param openId
     * @param logonType   登陆方式
     * @param logonStatus 登陆状态
     * @param failMessage 登陆错误信息，成功传null
     */
    private void logonFailLog(HttpSession session, String custNo, String openId, LogonControlLogonTypeEnum logonType, LogonControlLogonStatusEnum logonStatus, String failMessage) {
        LogonControl logonControl = new LogonControl();
        String logonSeq = DateUtil.getDateStr(new Date(), "yyyyMMdd") + String.valueOf(System.currentTimeMillis()).substring(1);
        logonControl.setWlcLogonSeq(logonSeq);
        logonControl.setWlcCustNo(custNo);
        logonControl.setWlcLogonType(logonType.getCode());
        logonControl.setWlcOpenid(openId);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logonControl.setWlcSessionKey(String.valueOf(session.getAttribute(HttpSessionAttributeConstant.SESSION_KEY)));
        logonControl.setWlcSessionid(session.getId());
        logonControl.setWlcLogonTime(new Date());
        // 增加了代理服务器之后获取用户ip
        String logonIp = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
            logonIp = request.getRemoteAddr();
        }
        logonControl.setWlcLogonIp(logonIp);
        LogonControl lastLogonControl = logonControlMapper.selectLastOneByOpenId(logonControl.getWlcOpenid());
        Long nowFailTimes = 0L;
        if (LogonControlLogonStatusEnum.FAIL == logonStatus) {
            nowFailTimes = 1L;
        }
        if (lastLogonControl == null) {
            logonControl.setWlcLastLogonTime(null);
            logonControl.setWlcLastLogonIp(null);
            logonControl.setWlcDayFailTimes(nowFailTimes);
            logonControl.setWlcTotalFailTimes(nowFailTimes);
        } else {
            logonControl.setWlcLastLogonTime(lastLogonControl.getWlcLogonTime());
            logonControl.setWlcLastLogonIp(lastLogonControl.getWlcLogonIp());
            if (DateUtil.getDateStr(logonControl.getWlcLogonTime(), "yyyyMMdd").equals(DateUtil.getDateStr(lastLogonControl.getWlcLogonTime(), "yyyyMMdd"))) {
                logonControl.setWlcDayFailTimes(lastLogonControl.getWlcDayFailTimes() + nowFailTimes);
            } else {
                logonControl.setWlcDayFailTimes(nowFailTimes);
            }
            logonControl.setWlcTotalFailTimes(lastLogonControl.getWlcTotalFailTimes() + nowFailTimes);
        }
        logonControl.setWlcLogonStatus(logonStatus.getCode());
        logonControl.setWlcFailMsg(failMessage);
        logonControlMapper.insertSelective(logonControl);
    }
}
