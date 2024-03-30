package com.rone.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信小程序登陆VO
 *
 * @author rone
 */
@ApiModel
public class WeChatLogonVO {

    /**
     * 未注册
     */
    public static final Integer NO_REGISTER = 0;
    /**
     * 未登录
     */
    public static final Integer NO_LOGON = 1;
    /**
     * 已登录
     */
    public static final Integer LOGON = 2;

    @ApiModelProperty("sessionId")
    private String sessionId;
    @ApiModelProperty("登陆状态，0：未注册；1：未登录；2：已登录")
    private Integer logonStatus;
    @ApiModelProperty("默认登陆的手机号")
    private String mobileNo;
    @ApiModelProperty("用户类型")
    private String userInfoType;
    @ApiModelProperty("人机验证频率，分钟")
    private Integer humanVerificationMinutes;
    @ApiModelProperty("人机验证频率，次数")
    private Integer humanVerificationTimes;
    @ApiModelProperty("人机验证-摇一摇幅度")
    private String humanVerificationShakeRange;

    public static WeChatLogonVO noRegister(String sessionId, String mobileNo, Integer humanVerificationMinutes, Integer humanVerificationTimes, String humanVerificationShakeRange) {
        return new WeChatLogonVO(sessionId, NO_REGISTER, mobileNo, "", humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
    }

    public static WeChatLogonVO logon(String sessionId, String mobileNo, String userInfoType, Integer humanVerificationMinutes, Integer humanVerificationTimes, String humanVerificationShakeRange) {
        return new WeChatLogonVO(sessionId, LOGON, mobileNo, userInfoType, humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
    }

    public static WeChatLogonVO noLogon(String sessionId, String mobileNo, String userInfoType, Integer humanVerificationMinutes, Integer humanVerificationTimes, String humanVerificationShakeRange) {
        return new WeChatLogonVO(sessionId, NO_LOGON, mobileNo, userInfoType, humanVerificationMinutes, humanVerificationTimes, humanVerificationShakeRange);
    }

    public WeChatLogonVO(String sessionId, Integer logonStatus, String mobileNo, String userInfoType, Integer humanVerificationMinutes, Integer humanVerificationTimes, String humanVerificationShakeRange) {
        this.sessionId = sessionId;
        this.logonStatus = logonStatus;
        this.mobileNo = mobileNo;
        this.userInfoType = userInfoType;
        this.humanVerificationMinutes = humanVerificationMinutes;
        this.humanVerificationTimes = humanVerificationTimes;
        this.humanVerificationShakeRange = humanVerificationShakeRange;
    }

    public WeChatLogonVO() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getLogonStatus() {
        return logonStatus;
    }

    public void setLogonStatus(Integer logonStatus) {
        this.logonStatus = logonStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserInfoType() {
        return userInfoType;
    }

    public void setUserInfoType(String userInfoType) {
        this.userInfoType = userInfoType;
    }

    public Integer getHumanVerificationMinutes() {
        return humanVerificationMinutes;
    }

    public void setHumanVerificationMinutes(Integer humanVerificationMinutes) {
        this.humanVerificationMinutes = humanVerificationMinutes;
    }

    public Integer getHumanVerificationTimes() {
        return humanVerificationTimes;
    }

    public void setHumanVerificationTimes(Integer humanVerificationTimes) {
        this.humanVerificationTimes = humanVerificationTimes;
    }

    public String getHumanVerificationShakeRange() {
        return humanVerificationShakeRange;
    }

    public void setHumanVerificationShakeRange(String humanVerificationShakeRange) {
        this.humanVerificationShakeRange = humanVerificationShakeRange;
    }
}
