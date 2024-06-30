package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 领取权益
 *
 * @author rone
 */
public class ReceiveRightsQO extends CommonQO {
    @ApiModelProperty("手机号码")
    private String mobileNo;
    @ApiModelProperty("短信验证码")
    private String smsAuthCode;
    @ApiModelProperty("权益活动ID")
    private Integer rightsId;

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

    public Integer getRightsId() {
        return rightsId;
    }

    public void setRightsId(Integer rightsId) {
        this.rightsId = rightsId;
    }
}
