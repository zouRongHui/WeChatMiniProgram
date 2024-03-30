package com.rone.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 启动页配置参数
 *
 * @author rone
 */
public class LaunchPageVO {

    @ApiModelProperty("启动页图片路径")
    private String picture;
    @ApiModelProperty("启动页链接地址")
    private String redirect;
    @ApiModelProperty("启动页持续市场，单位毫秒")
    private Integer duration;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
