package com.rone.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户基本信息
 *
 * @author rone
 */
@ApiModel
public class UserInfoVO {

    @ApiModelProperty("手机号码")
    private String mobileNo;

    @ApiModelProperty("用户类型，部分用户行为有用户类型的限制")
    private String userType;

    public UserInfoVO(String mobileNo, String userType) {
        this.mobileNo = mobileNo;
        this.userType = userType;
    }

    public UserInfoVO() {
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
