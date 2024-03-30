package com.rone.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel
public class UserInfoTokenVO {
    @ApiModelProperty("手机号码")
    private String mobileNo;
    @ApiModelProperty("小程序用户open_id")
    private String openId;

    public UserInfoTokenVO() {
    }

    public UserInfoTokenVO(String mobileNo, String openId) {
        this.mobileNo = mobileNo;
        this.openId = openId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
