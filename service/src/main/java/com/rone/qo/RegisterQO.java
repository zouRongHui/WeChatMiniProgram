package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 注册参数
 *
 * @author rone
 */
public class RegisterQO extends CommonQO {
    @ApiModelProperty("手机号码")
    private String mobileNo;
    @ApiModelProperty("短信验证码")
    private String smsAuthCode;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSmsAuthCode() {
        return smsAuthCode;
    }

    public void setSmsAuthCode(String smsAuthCode) {
        this.smsAuthCode = smsAuthCode;
    }
}
