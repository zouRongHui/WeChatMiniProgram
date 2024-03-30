package com.rone.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 小程序信息提醒表
 *
 * @author rone
 */
@ApiModel
public class MsgInfoVo {
    /**
     * ID
     */
    @ApiModelProperty("编号")
    private Integer id;
    /**
     * 客户号
     */
    @ApiModelProperty("客户号")
    private String custno;
    /**
     * 客户微信openid
     */
    @ApiModelProperty("客户微信openid")
    private String openid;
    /**
     * 信息内容
     */
    @ApiModelProperty("信息内容")
    private String msgText;
    /**
     * 信息类型
     */
    @ApiModelProperty("信息类型")
    private String msgType;

    public MsgInfoVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno == null ? null : custno.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText == null ? null : msgText.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }


}