package com.rone.model;

import java.util.Date;

/**
 * 短信验证码相关属性
 *
 * @author rone
 */
public class SmsAuthCode {
    public static final Integer TIME_OUT = 5 * 60 * 1000;

    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 短信验证码
     */
    private Integer code;
    /**
     * 发送时间
     */
    private Date sendTime;

    public SmsAuthCode(String mobileNo, Integer code, Date sendTime) {
        this.mobileNo = mobileNo;
        this.code = code;
        this.sendTime = sendTime;
    }

    public SmsAuthCode() {
    }

    /**
     * 检查短信验证码是否超时
     *
     * @param now
     * @return true：超时
     */
    public Boolean checkTimeOut(Date now) {
        return now.getTime() - this.sendTime.getTime() > TIME_OUT;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
