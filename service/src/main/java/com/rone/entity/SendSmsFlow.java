package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信发送流水
 *
 * @author rone
 */
public class SendSmsFlow implements Serializable {
    /**
     * 流水号
     */
    private String seq;

    /**
     * 短信类型，0:其他;1:验证码
     */
    private String smsType;

    /**
     * 请求发送短信的ip
     */
    private String ip;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 发送时间
     */
    private Date time;

    /**
     * 短信内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType == null ? null : smsType.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}