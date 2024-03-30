package com.rone.model;

import com.rone.entity.UserInfo;

import java.util.Map;

/**
 * 用户信息VO
 *
 * @author rone
 */
public class LogonUserInfo {

    /**
     * 客户编号
     */
    private String wuiCustNo;

    /**
     * 微信OPENID
     */
    private String wuiOpenid;

    /**
     * 手机号码
     */
    private String wuiMobileNo;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 微信的用户加密密钥对，key：密钥版本号、value：密钥
     */
    private Map<Integer, String> weChatUserEncryptKeyMap;

    public LogonUserInfo() {
    }

    public LogonUserInfo(UserInfo userInfo, Map<Integer, String> weChatUserEncryptKeyMap) {
        this.wuiCustNo = userInfo.getWuiCustNo();
        this.wuiOpenid = userInfo.getWuiOpenid();
        this.wuiMobileNo = userInfo.getWuiMobileNo();
        this.userType = userInfo.getUserType();
        this.weChatUserEncryptKeyMap = weChatUserEncryptKeyMap;
    }

    public String getWuiCustNo() {
        return wuiCustNo;
    }

    public void setWuiCustNo(String wuiCustNo) {
        this.wuiCustNo = wuiCustNo;
    }

    public String getWuiOpenid() {
        return wuiOpenid;
    }

    public void setWuiOpenid(String wuiOpenid) {
        this.wuiOpenid = wuiOpenid;
    }

    public String getWuiMobileNo() {
        return wuiMobileNo;
    }

    public void setWuiMobileNo(String wuiMobileNo) {
        this.wuiMobileNo = wuiMobileNo;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Map<Integer, String> getWeChatUserEncryptKeyMap() {
        return weChatUserEncryptKeyMap;
    }

    public void setWeChatUserEncryptKeyMap(Map<Integer, String> weChatUserEncryptKeyMap) {
        this.weChatUserEncryptKeyMap = weChatUserEncryptKeyMap;
    }
}
