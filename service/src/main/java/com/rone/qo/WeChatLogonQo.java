package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 微信小程序参数
 *
 * @author rone
 */
public class WeChatLogonQo extends CommonQO {
    @ApiModelProperty("wx.login() 获取的临时登录凭证js_code")
    private String jsCode;

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }
}
