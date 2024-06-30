package com.rone.service.impl;

import com.rone.constant.HttpSessionAttributeConstant;
import com.rone.dao.RightsActivityAllowListMapper;
import com.rone.dao.RightsActivityMapper;
import com.rone.dao.RightsReceiveLogMapper;
import com.rone.dao.UserInfoMapper;
import com.rone.entity.*;
import com.rone.enumeration.RightsActivityPhaseRightsNumCycleEnum;
import com.rone.enumeration.RightsActivityReceiveTimesSingleFrequencyEnum;
import com.rone.enumeration.RightsActivityStatusEnum;
import com.rone.enumeration.YesOrNoEnum;
import com.rone.enums.user.UserInfoStatusEnum;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.exception.SessionDueException;
import com.rone.model.SmsAuthCode;
import com.rone.qo.ReceiveRightsQO;
import com.rone.qo.RightsActivityFindByIdQO;
import com.rone.service.RightsActivityService;
import com.rone.session.RoneSessionContext;
import com.rone.utils.date.DateUtil;
import com.rone.utils.format.CheckFormatUtil;
import com.rone.vo.RightsActivityVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 权益活动
 *
 * @author rone
 */
@Service
@Transactional
public class RightsActivityServiceImpl implements RightsActivityService {

    /**
     * 当日的领取次数缓存
     * 针对需要限制领取数量的权益活动，先进行单机的数量限制，
     * 然后再通过分布式锁(数据库行锁实现)来争抢最终的领取资格
     */
    public static Map<Integer, AtomicInteger> receiveTimesMap = new HashMap<>();

    @Resource
    private RightsActivityMapper mapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private RightsReceiveLogMapper rightsReceiveLogMapper;
    @Resource
    private RightsActivityAllowListMapper rightsActivityAllowListMapper;

    @Override
    public List<RightsActivity> getInUse() {
        RightsActivityCriteria rightsActivityCriteria = new RightsActivityCriteria();
        rightsActivityCriteria.createCriteria()
                .andDeleteFlagEqualTo(YesOrNoEnum.NO.getCode())
                .andStatusEqualTo(RightsActivityStatusEnum.USABLE.getCode());
        return mapper.selectByExample(rightsActivityCriteria);
    }

    @Override
    public RightsActivityVO findVOById(RightsActivityFindByIdQO qo) throws ParamException {
        RightsActivity rightsActivity = mapper.selectByPrimaryKey(qo.getId());
        if (rightsActivity == null || RightsActivityStatusEnum.DISABLE.getCode().equals(rightsActivity.getStatus())) {
            throw new ParamException("无此活动或活动未开始！");
        }
        boolean receiveTimeAble = true;
        // 不在活动时间内，至于是否在领取的时间内则交由客户端来判断
        if (StringUtils.isNotEmpty(rightsActivity.getStartDate())) {
            Date startDate = DateUtil.strToDate(rightsActivity.getStartDate(), "yyyy-MM-dd");
            if ((new Date()).getTime() < startDate.getTime()) {
                receiveTimeAble = false;
            }
        }
        if (StringUtils.isNotEmpty(rightsActivity.getEndDate())) {
            Date endDate = DateUtil.strToDate(rightsActivity.getEndDate(), "yyyy-MM-dd");
            endDate = DateUtil.changeDayOfMonth(endDate, 1);
            if ((new Date()).getTime() > endDate.getTime()) {
                receiveTimeAble = false;
            }
        }
        if (StringUtils.isNotEmpty(rightsActivity.getReceiveCycle())) {
            Calendar now = Calendar.getInstance();
            int week = now.get(Calendar.DAY_OF_WEEK);
            if (!rightsActivity.getReceiveCycle().contains(String.valueOf(week))) {
                receiveTimeAble = false;
            }
        }

        boolean receiveTotalNumAble = rightsActivity.getReceiveTimesTotal() == null || rightsActivity.getReceiveTimesTotal() <= 0 || rightsActivity.getReceiveTimesSurplus() > 0;
        // 总额度没有了
        // 阶段性的额度没有了
        if (rightsActivity.getPhaseRightsTotalNum() != null && rightsActivity.getPhaseRightsTotalNum() > 0) {
            RightsReceiveLogCriteria rightsReceiveLogCriteria = new RightsReceiveLogCriteria();
            RightsReceiveLogCriteria.Criteria criteria = rightsReceiveLogCriteria.createCriteria();
            criteria.andRightsIdEqualTo(rightsActivity.getRightsId());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            if (rightsActivity.getPhaseRightsNumCycle() != null) {
                switch (RightsActivityPhaseRightsNumCycleEnum.getByCode(rightsActivity.getPhaseRightsNumCycle())) {
                    case DAY:
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        break;
                    case WEEK:
                        calendar.set(Calendar.DAY_OF_WEEK, 2);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        break;
                    case MONTH:
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.MONTH, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        break;
                    case YEAR:
                        calendar.set(Calendar.DAY_OF_YEAR, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.YEAR, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        break;
                }
            }
            if (rightsReceiveLogMapper.countByExample(rightsReceiveLogCriteria) >= rightsActivity.getPhaseRightsTotalNum()) {
                receiveTotalNumAble = false;
            }
        }

        boolean receiveUserNumAble = rightsActivity.getReceiveTimesSingle() == null || rightsActivity.getReceiveTimesSingle() <= 0;
        boolean receiveAuthAble = !YesOrNoEnum.YES.getCode().toString().equals(rightsActivity.getHasAllowList());
        // 判断该权益是否配置了白名单
        if (!receiveUserNumAble || !receiveAuthAble) {
            try {
                HttpSession session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
                String openId = String.valueOf(session.getAttribute(HttpSessionAttributeConstant.OPEN_ID));
                if (StringUtils.isNotEmpty(openId) && !"null".equals(openId)) {
                    UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
                    userInfoCriteria.createCriteria()
                            .andWuiOpenidEqualTo(openId)
                            .andWuiStatusEqualTo(UserInfoStatusEnum.NORMAL.getCode());
                    List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoCriteria);
                    if (userInfoList != null && !userInfoList.isEmpty()) {
                        UserInfo userInfo = userInfoList.get(0);
                        // 检查当前用户此时是否还有领取次数
                        if (!receiveUserNumAble) {
                            RightsReceiveLogCriteria rightsReceiveLogCriteria = new RightsReceiveLogCriteria();
                            RightsReceiveLogCriteria.Criteria criteria = rightsReceiveLogCriteria.createCriteria();
                            criteria.andRightsIdEqualTo(rightsActivity.getRightsId());
                            criteria.andPhoneEqualTo(userInfo.getWuiMobileNo());
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, 0);
                            calendar.set(Calendar.MINUTE, 0);
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);
                            if (rightsActivity.getReceiveTimesSingleFrequency() != null) {
                                switch (RightsActivityReceiveTimesSingleFrequencyEnum.getByCode(rightsActivity.getReceiveTimesSingleFrequency())) {
                                    case WHOLE:
                                        break;
                                    case DAY:
                                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                                        criteria.andReceiveTimeLessThan(calendar.getTime());
                                        break;
                                    case WEEK:
                                        calendar.set(Calendar.DAY_OF_WEEK, 2);
                                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                                        criteria.andReceiveTimeLessThan(calendar.getTime());
                                        break;
                                    case MONTH:
                                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                                        calendar.add(Calendar.MONTH, 1);
                                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                                        break;
                                    case YEAR:
                                        calendar.set(Calendar.DAY_OF_YEAR, 1);
                                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                                        calendar.add(Calendar.YEAR, 1);
                                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                                        break;
                                }
                            }
                            if (rightsReceiveLogMapper.countByExample(rightsReceiveLogCriteria) < rightsActivity.getReceiveTimesSingle()) {
                                receiveUserNumAble = true;
                            }
                        }

                        // 检查白名单
                        if (!receiveAuthAble) {
                            // 校验白名单查看用户是否有权限
                            RightsActivityAllowListCriteria rightsActivityAllowListCriteria = new RightsActivityAllowListCriteria();
                            rightsActivityAllowListCriteria.createCriteria().andRightsActivityIdEqualTo(rightsActivity.getId()).andPhoneEqualTo(userInfo.getWuiMobileNo());
                            if (rightsActivityAllowListMapper.countByExample(rightsActivityAllowListCriteria) > 0L) {
                                receiveAuthAble = true;
                            }
                        }
                    }
                }
            } catch (RoneException e) {
                e.printStackTrace();
            }
        }

        return new RightsActivityVO(rightsActivity, receiveTimeAble, receiveUserNumAble, receiveTotalNumAble, receiveAuthAble);
    }

    @Override
    public void receiveRights(ReceiveRightsQO qo) throws RoneException {
        String mobileNo = qo.getMobileNo();
        String smsAuthCode = qo.getSmsAuthCode();
        Integer rightsId = qo.getRightsId();
        Date now = new Date();

        // 校验参数
        if (!CheckFormatUtil.isMobile(mobileNo)) {
            throw new ParamException("手机号码格式不正确！");
        }
        HttpSession session;
        try {
            session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
        } catch (RoneException e) {
            throw new SessionDueException("领取失败，长时间未完成领取操作！");
        }
        String openId = String.valueOf(session.getAttribute(HttpSessionAttributeConstant.OPEN_ID));
        if (StringUtils.isEmpty(openId) || "null".equals(openId)) {
            throw new SessionDueException("领取失败，长时间未完成领取操作！");
        }
        RightsActivity rightsActivity = mapper.selectByPrimaryKey(rightsId);
        if (rightsActivity == null) {
            throw new ParamException("领取失败，活动不存在！");
        }

        // 验证短信验证码
        SmsAuthCode smsAuthCodeObject = (SmsAuthCode) session.getAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);
        if (smsAuthCodeObject == null) {
            throw new RoneException("领取失败，未发送手机验证码！");
        }
        if (!mobileNo.trim().equals(smsAuthCodeObject.getMobileNo())) {
            throw new RoneException("领取失败，手机号码与发送验证码的手机号码不一致！");
        }
        if (smsAuthCodeObject.checkTimeOut(new Date())) {
            throw new RoneException("领取失败，验证码已过期！");
        }
        if (!smsAuthCode.equals(String.valueOf(smsAuthCodeObject.getCode()))) {
            throw new RoneException("领取失败，手机验证码错误！");
        }
        session.removeAttribute(HttpSessionAttributeConstant.SMS_AUTH_CODE);

        // 检查是否注册，若未注册则无法领取
        UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
        userInfoCriteria.createCriteria()
                .andWuiOpenidEqualTo(openId)
                .andWuiStatusEqualTo(UserInfoStatusEnum.NORMAL.getCode());
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoCriteria);
        if (userInfoList == null || userInfoList.isEmpty()) {
            throw new RoneException("领取失败，当前未注册请先完成注册！");
        }
        UserInfo userInfo = userInfoList.get(0);
        if (!mobileNo.equals(userInfo.getWuiMobileNo())) {
            throw new RoneException("领取失败，该手机号并非当前用户注册登记的手机号！");
        }

        // 检查权益活动是否开启
        if (RightsActivityStatusEnum.DISABLE.getCode().equals(rightsActivity.getStatus())) {
            throw new RoneException("领取失败，当前活动还未开始！");
        }
        if (YesOrNoEnum.YES.getCode().equals(rightsActivity.getDeleteFlag())) {
            throw new RoneException("领取失败，当前活动已经结束！");
        }

        // 若配置了领取时间，判断是否在可领取时间内
        if (StringUtils.isNotEmpty(rightsActivity.getStartDate())) {
            Date startDate = DateUtil.strToDate(rightsActivity.getStartDate(), "yyyy-MM-dd");
            if (now.getTime() < startDate.getTime()) {
                throw new RoneException("领取失败，当前不在活动时间内！");
            }
        }
        if (StringUtils.isNotEmpty(rightsActivity.getEndDate())) {
            Date endDate = DateUtil.strToDate(rightsActivity.getEndDate(), "yyyy-MM-dd");
            endDate = DateUtil.changeDayOfMonth(endDate, 1);
            if (now.getTime() > endDate.getTime()) {
                throw new RoneException("领取失败，当前不在活动时间内！");
            }
        }
        if (StringUtils.isNotEmpty(rightsActivity.getReceiveCycle())) {
            Calendar calendar = Calendar.getInstance();
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (!rightsActivity.getReceiveCycle().contains(String.valueOf(week))) {
                throw new RoneException("领取失败，当前不在活动时间内！");
            }
        }
        String yearMonthDay = DateUtil.getDateStr(now, "yyyy-MM-dd ");
        if (StringUtils.isNotEmpty(rightsActivity.getStartTime())) {
            Date startTime = DateUtil.strToDate(yearMonthDay + rightsActivity.getStartTime(), "yyyy-MM-dd hh:mm:ss");
            if (now.getTime() < startTime.getTime()) {
                throw new RoneException("领取失败，当前不在领取时间内！");
            }
        }
        if (StringUtils.isNotEmpty(rightsActivity.getEndTime())) {
            Date endTime = DateUtil.strToDate(yearMonthDay + rightsActivity.getEndTime(), "yyyy-MM-dd hh:mm:ss");
            if (now.getTime() > endTime.getTime()) {
                throw new RoneException("领取失败，当前不在领取时间内！");
            }
        }

        // 若配置了白名单，通过DB判断该用户是否在白名单中，判断该用户是否有领取资格
        if (YesOrNoEnum.YES.getCode().toString().equals(rightsActivity.getHasAllowList())) {
            RightsActivityAllowListCriteria rightsActivityAllowListCriteria = new RightsActivityAllowListCriteria();
            rightsActivityAllowListCriteria.createCriteria().andRightsActivityIdEqualTo(rightsActivity.getId()).andPhoneEqualTo(userInfo.getWuiMobileNo());
            if (rightsActivityAllowListMapper.countByExample(rightsActivityAllowListCriteria) < 1L) {
                throw new RoneException("领取失败，当前账号无领取权限！");
            }
        }

        // 领取资格的争抢：先单机进行争抢(数量为今日能领取的最大数量)，然后集群通过分布式锁(数据库行锁实现)最终进行实际领取资格的争抢
        // 单机的权益领取资格限制
        if ((rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0) || (rightsActivity.getPhaseRightsTotalNum() != null && rightsActivity.getPhaseRightsTotalNum() > 0)) {
            AtomicInteger receiveTimes = receiveTimesMap.get(rightsActivity.getId());
            if (receiveTimes != null) {
                if (rightsActivity.getPhaseRightsTotalNum() != null) {
                    if (receiveTimes.get() >= rightsActivity.getPhaseRightsTotalNum()) {
                        throw new RoneException("当前权益数量已领完，请关注下个周期权益");
                    }
                }
                if (rightsActivity.getReceiveTimesTotal() != null) {
                    if (receiveTimes.get() >= rightsActivity.getReceiveTimesTotal()) {
                        throw new RoneException("当前权益数量已领完，请关注下个周期权益！");
                    }
                }
            } else {
                synchronized (RightsActivityServiceImpl.class) {
                    if (receiveTimesMap.get(rightsActivity.getId()) == null) {
                        receiveTimes = new AtomicInteger();
                        receiveTimesMap.put(rightsActivity.getId(), receiveTimes);
                    } else {
                        receiveTimes = receiveTimesMap.get(rightsActivity.getId());
                    }
                }
            }
            int hasPassNum = receiveTimes.incrementAndGet();
            if (rightsActivity.getPhaseRightsTotalNum() != null) {
                if (hasPassNum > rightsActivity.getPhaseRightsTotalNum()) {
                    throw new RoneException("当前权益数量已领完，请关注下个周期权益");
                }
            }
            if (rightsActivity.getReceiveTimesTotal() != null) {
                if (hasPassNum > rightsActivity.getReceiveTimesTotal()) {
                    throw new RoneException("当前权益数量已领完，请关注下个周期权益！");
                }
            }
        }

        // 分布式锁进行领取资格判断
        // 先进行首次判断，悲观的认为大概率当前已经没有领取次数了
        this.checkHasReceiveTimes(rightsActivity, userInfo);
        // 获取锁
        rightsActivity = mapper.lock(rightsActivity.getId());
        // 再次进行判断
        this.checkHasReceiveTimes(rightsActivity, userInfo);

        // 若配置了相关限制参数则更新权益的配置数据
        if (rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0) {
            // 限制了了总领取次数
            rightsActivity.setReceiveTimesDone(rightsActivity.getReceiveTimesDone() + 1);
            rightsActivity.setReceiveTimesSurplus(rightsActivity.getReceiveTimesSurplus() - 1);
        }

        // 登记领取记录
        RightsReceiveLog rightsReceiveLog = new RightsReceiveLog();
        rightsReceiveLog.setOpenId(userInfo.getWuiOpenid());
        rightsReceiveLog.setPhone(userInfo.getWuiMobileNo());
        rightsReceiveLog.setRightsId(rightsActivity.getRightsId());
        rightsReceiveLog.setRightsStartDate(rightsActivity.getRightsStartDate());
        rightsReceiveLog.setRightsEndDate(rightsActivity.getRightsEndDate());
        rightsReceiveLog.setRightsNum(rightsActivity.getRightsNum());
        rightsReceiveLog.setReceiveTime(new Date());
        rightsReceiveLogMapper.insert(rightsReceiveLog);

        // 释放锁
        mapper.updateByPrimaryKey(rightsActivity);
    }

    /**
     * 判断是否还有领取的次数
     *
     * @param rightsActivity
     * @param userInfo
     * @throws RoneException
     */
    private void checkHasReceiveTimes(RightsActivity rightsActivity, UserInfo userInfo) throws RoneException {
        // 总额度
        if (rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0) {
            if (rightsActivity.getReceiveTimesSurplus() <= 0) {
                throw new RoneException("当前权益数量已领完，请关注下个周期权益！");
            }
        }

        // 若配置了单人领取额度，检测当前用户权益是否超过领取次数
        if (rightsActivity.getReceiveTimesSingle() != null && rightsActivity.getReceiveTimesSingle() > 0) {
            RightsReceiveLogCriteria rightsReceiveLogCriteria = new RightsReceiveLogCriteria();
            RightsReceiveLogCriteria.Criteria criteria = rightsReceiveLogCriteria.createCriteria();
            criteria.andRightsIdEqualTo(rightsActivity.getRightsId());
            criteria.andPhoneEqualTo(userInfo.getWuiMobileNo());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            String errorMessage = "您已经领取完了，无法再次领取！";
            if (rightsActivity.getReceiveTimesSingleFrequency() != null) {
                switch (RightsActivityReceiveTimesSingleFrequencyEnum.getByCode(rightsActivity.getReceiveTimesSingleFrequency())) {
                    case WHOLE:
                        break;
                    case DAY:
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        errorMessage = "您今天已经领取完了，无法再次领取！";
                        break;
                    case WEEK:
                        calendar.set(Calendar.DAY_OF_WEEK, 2);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        errorMessage = "您本周已经领取完了，无法再次领取！";
                        break;
                    case MONTH:
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.MONTH, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        errorMessage = "您当月已经领取完了，无法再次领取！";
                        break;
                    case YEAR:
                        calendar.set(Calendar.DAY_OF_YEAR, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.YEAR, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        errorMessage = "您今年已经领取完了，无法再次领取！";
                        break;
                }
            }
            if (rightsReceiveLogMapper.countByExample(rightsReceiveLogCriteria) >= rightsActivity.getReceiveTimesSingle()) {
                throw new RoneException("领取失败，" + errorMessage);
            }
        }

        // 若配置了阶段领取额度，检测当前阶段是否还有剩余额度
        if (rightsActivity.getPhaseRightsTotalNum() != null && rightsActivity.getPhaseRightsTotalNum() > 0) {
            RightsReceiveLogCriteria rightsReceiveLogCriteria = new RightsReceiveLogCriteria();
            RightsReceiveLogCriteria.Criteria criteria = rightsReceiveLogCriteria.createCriteria();
            criteria.andRightsIdEqualTo(rightsActivity.getRightsId());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            String errorMessage = "";
            if (rightsActivity.getPhaseRightsNumCycle() != null) {
                switch (RightsActivityPhaseRightsNumCycleEnum.getByCode(rightsActivity.getPhaseRightsNumCycle())) {
                    case DAY:
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        errorMessage = "今日已领取完毕！";
                        break;
                    case WEEK:
                        calendar.set(Calendar.DAY_OF_WEEK, 2);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        criteria.andReceiveTimeLessThan(calendar.getTime());
                        errorMessage = "本周已领取完毕！";
                        break;
                    case MONTH:
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.MONTH, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        errorMessage = "本月已领取完毕！";
                        break;
                    case YEAR:
                        calendar.set(Calendar.DAY_OF_YEAR, 1);
                        criteria.andReceiveTimeGreaterThanOrEqualTo(calendar.getTime());
                        calendar.add(Calendar.YEAR, 1);
                        criteria.andReceiveTimeLessThanOrEqualTo(calendar.getTime());
                        errorMessage = "今年已领取完毕！";
                        break;
                }
            }
            if (rightsReceiveLogMapper.countByExample(rightsReceiveLogCriteria) >= rightsActivity.getPhaseRightsTotalNum()) {
                throw new RoneException("领取失败，" + errorMessage);
            }
        }
    }
}
