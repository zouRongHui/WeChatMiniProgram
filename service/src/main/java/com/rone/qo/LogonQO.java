package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登陆参数
 *
 * @author rone
 */
public class LogonQO extends CommonQO {

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
