package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 小程序用户信息表
 *
 * @author rone
 */
public class UserInfo implements Serializable {
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
     * 用户状态 00:正常；01:临时锁定；02:永久锁定；03:注销；
     */
    private String wuiStatus;
    /**
     * 注册时间
     */
    private Date wuiRegisterTime;
    /**
     * 微信UNIONID
     */
    private String wuiUnionid;
    /**
     * 用户类型，{@link com.rone.enumeration.UserInfoTypeEnum}
     */
    private Integer userType;

    private static final long serialVersionUID = 1L;

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

    public String getWuiStatus() {
        return wuiStatus;
    }

    public void setWuiStatus(String wuiStatus) {
        this.wuiStatus = wuiStatus;
    }

    public Date getWuiRegisterTime() {
        return wuiRegisterTime;
    }

    public void setWuiRegisterTime(Date wuiRegisterTime) {
        this.wuiRegisterTime = wuiRegisterTime;
    }

    public String getWuiUnionid() {
        return wuiUnionid;
    }

    public void setWuiUnionid(String wuiUnionid) {
        this.wuiUnionid = wuiUnionid;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}