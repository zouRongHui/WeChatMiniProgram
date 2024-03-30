package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 微店小程序登录控制表
 *
 * @author rone
 */
public class LogonControl implements Serializable {
    /**
     * YYYYMMDD+12位序号
     */
    private String wlcLogonSeq;

    /**
     * 客户编号
     */
    private String wlcCustNo;

    /**
     * 1:手机验证码；2:指纹
     */
    private String wlcLogonType;

    /**
     * 微信OPENID
     */
    private String wlcOpenid;

    /**
     * 微信登录会话密钥
     */
    private String wlcSessionKey;

    /**
     * 会话id
     */
    private String wlcSessionid;

    /**
     * 登录时间
     */
    private Date wlcLogonTime;

    /**
     * 登录IP
     */
    private String wlcLogonIp;

    /**
     * 上次登录时间
     */
    private Date wlcLastLogonTime;

    /**
     * 上次登录IP
     */
    private String wlcLastLogonIp;

    /**
     * 登录状态 0:成功；2:失败
     */
    private String wlcLogonStatus;

    /**
     * 登录失败信息
     */
    private String wlcFailMsg;

    /**
     * 当日失败次数
     */
    private Long wlcDayFailTimes;

    /**
     * 累计失败次数
     */
    private Long wlcTotalFailTimes;

    private static final long serialVersionUID = 1L;

    public String getWlcLogonSeq() {
        return wlcLogonSeq;
    }

    public void setWlcLogonSeq(String wlcLogonSeq) {
        this.wlcLogonSeq = wlcLogonSeq == null ? null : wlcLogonSeq.trim();
    }

    public String getWlcCustNo() {
        return wlcCustNo;
    }

    public void setWlcCustNo(String wlcCustNo) {
        this.wlcCustNo = wlcCustNo == null ? null : wlcCustNo.trim();
    }

    public String getWlcLogonType() {
        return wlcLogonType;
    }

    public void setWlcLogonType(String wlcLogonType) {
        this.wlcLogonType = wlcLogonType == null ? null : wlcLogonType.trim();
    }

    public String getWlcOpenid() {
        return wlcOpenid;
    }

    public void setWlcOpenid(String wlcOpenid) {
        this.wlcOpenid = wlcOpenid == null ? null : wlcOpenid.trim();
    }

    public String getWlcSessionKey() {
        return wlcSessionKey;
    }

    public void setWlcSessionKey(String wlcSessionKey) {
        this.wlcSessionKey = wlcSessionKey == null ? null : wlcSessionKey.trim();
    }

    public String getWlcSessionid() {
        return wlcSessionid;
    }

    public void setWlcSessionid(String wlcSessionid) {
        this.wlcSessionid = wlcSessionid == null ? null : wlcSessionid.trim();
    }

    public Date getWlcLogonTime() {
        return wlcLogonTime;
    }

    public void setWlcLogonTime(Date wlcLogonTime) {
        this.wlcLogonTime = wlcLogonTime;
    }

    public String getWlcLogonIp() {
        return wlcLogonIp;
    }

    public void setWlcLogonIp(String wlcLogonIp) {
        this.wlcLogonIp = wlcLogonIp == null ? null : wlcLogonIp.trim();
    }

    public Date getWlcLastLogonTime() {
        return wlcLastLogonTime;
    }

    public void setWlcLastLogonTime(Date wlcLastLogonTime) {
        this.wlcLastLogonTime = wlcLastLogonTime;
    }

    public String getWlcLastLogonIp() {
        return wlcLastLogonIp;
    }

    public void setWlcLastLogonIp(String wlcLastLogonIp) {
        this.wlcLastLogonIp = wlcLastLogonIp == null ? null : wlcLastLogonIp.trim();
    }

    public String getWlcLogonStatus() {
        return wlcLogonStatus;
    }

    public void setWlcLogonStatus(String wlcLogonStatus) {
        this.wlcLogonStatus = wlcLogonStatus == null ? null : wlcLogonStatus.trim();
    }

    public String getWlcFailMsg() {
        return wlcFailMsg;
    }

    public void setWlcFailMsg(String wlcFailMsg) {
        this.wlcFailMsg = wlcFailMsg == null ? null : wlcFailMsg.trim();
    }

    public Long getWlcDayFailTimes() {
        return wlcDayFailTimes;
    }

    public void setWlcDayFailTimes(Long wlcDayFailTimes) {
        this.wlcDayFailTimes = wlcDayFailTimes;
    }

    public Long getWlcTotalFailTimes() {
        return wlcTotalFailTimes;
    }

    public void setWlcTotalFailTimes(Long wlcTotalFailTimes) {
        this.wlcTotalFailTimes = wlcTotalFailTimes;
    }
}