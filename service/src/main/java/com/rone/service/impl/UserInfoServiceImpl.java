package com.rone.service.impl;

import com.rone.constant.HttpSessionAttributeConstant;
import com.rone.dao.UserInfoMapper;
import com.rone.exception.RoneException;
import com.rone.model.LogonUserInfo;
import com.rone.qo.CommonQO;
import com.rone.service.UserInfoService;
import com.rone.session.RoneSessionContext;
import com.rone.vo.UserInfoVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * 用户信息
 *
 * @author rone
 */
@Component
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogonServiceImpl.class);
    @Resource
    private UserInfoMapper userInfoMapper;
    /**
     * 当前服务器IP
     */
    private String localIp;

    @Override
    public UserInfoVO userInfo(CommonQO qo) throws Exception {
        HttpSession session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
        LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);

        return new UserInfoVO(logonUserInfo.getWuiMobileNo(), String.valueOf(logonUserInfo.getUserType()));
    }

    @Override
    public String userToken(CommonQO qo) throws RoneException {
        HttpSession session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
        LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);

        String userToken = RandomStringUtils.randomAlphabetic(32);
        Calendar expireTime = Calendar.getInstance();
        expireTime.add(Calendar.MINUTE, 30);
        int result = userInfoMapper.updateUserToken(logonUserInfo.getWuiCustNo(), userToken, qo.getSessionId(), new Date(), expireTime.getTime(), getLocalIp());
        if (result < 1) {
            // 重来没获取过Token的用户
            userInfoMapper.insertUserToken(logonUserInfo.getWuiCustNo(), userToken, qo.getSessionId(), new Date(), expireTime.getTime(), getLocalIp());
        }
        return userToken;
    }

    private String getLocalIp() {
        if (StringUtils.isEmpty(localIp)) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                localIp = inetAddress.getHostAddress();
            } catch (UnknownHostException e) {
                LOGGER.error("获取当前服务器IP失败", e);
            }
        }
        return localIp;
    }
}
