package com.rone.model;

/**
 * 微信小程序登陆成功返回结果
 *
 * @author rone
 */
public class WeChatLogonResult {

    /**
     * 用户唯一标识
     */
    private String openId;

    /**
     * 会话密钥
     */
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明
     */
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
