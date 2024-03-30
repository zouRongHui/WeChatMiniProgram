package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 发送短信参数
 *
 * @author rone
 */
public class SendSMSAuthCodeQO extends CommonQO {
    @ApiModelProperty("手机号码")
    private String mobileNo;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
