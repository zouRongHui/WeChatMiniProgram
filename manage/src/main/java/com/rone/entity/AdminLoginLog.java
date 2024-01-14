package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理平台登陆日志
 *
 * @author rone
 */
public class AdminLoginLog implements Serializable {
    /**
     * 登陆账号
     */
    private String loginAccount;

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 登陆的时间
     */
    private Date loginTime;

    /**
     * 登陆IP
     */
    private String loginIp;

    /**
     * 登陆状态，{@link com.rone.enumeration.AdminLoginLogStatusEnum}
     */
    private String loginStatus;

    /**
     * 登陆失败信息
     */
    private String loginFailMessage;

    private static final long serialVersionUID = 1L;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus == null ? null : loginStatus.trim();
    }

    public String getLoginFailMessage() {
        return loginFailMessage;
    }

    public void setLoginFailMessage(String loginFailMessage) {
        this.loginFailMessage = loginFailMessage == null ? null : loginFailMessage.trim();
    }
}