package com.rone.service;

import com.rone.qo.*;
import com.rone.vo.UserInfoVO;
import com.rone.vo.WeChatLogonVO;

/**
 * 登陆注册服务
 *
 * @author rone
 */
public interface LogonService {

    /**
     * 微信小程序登陆
     *
     * @param weChatLogonQo
     * @return
     * @throws Exception
     */
    WeChatLogonVO weChatLogon(WeChatLogonQo weChatLogonQo) throws Exception;

    /**
     * 发送验证短信
     *
     * @param sendSMSAuthCodeQO
     * @throws Exception
     */
    void sendSMSAuthCode(SendSMSAuthCodeQO sendSMSAuthCodeQO) throws Exception;

    /**
     * 注册
     *
     * @param registerQO
     * @return
     * @throws Exception
     */
    UserInfoVO register(RegisterQO registerQO) throws Exception;

    /**
     * 登陆
     *
     * @param logonQO
     * @return
     */
    UserInfoVO logon(LogonQO logonQO) throws Exception;

    /**
     * 登出
     *
     * @param qo
     */
    void logonOut(CommonQO qo) throws Exception;
}
