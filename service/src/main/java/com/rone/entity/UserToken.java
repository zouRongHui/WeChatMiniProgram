package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户Token表
 *
 * @author rone
 */
public class UserToken implements Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户Token
     */
    private String userToken;

    /**
     * 申请Token时的sessionId
     */
    private String sessionId;

    /**
     * Token签发时间
     */
    private Date createTime;

    /**
     * Token失效时间
     */
    private Date expireTime;

    /**
     * 服务器IP
     */
    private String serverIp;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken == null ? null : userToken.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}