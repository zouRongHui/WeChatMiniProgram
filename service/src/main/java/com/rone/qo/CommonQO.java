package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 公共请求体
 *
 * @author rone
 */
public class CommonQO {

    @ApiModelProperty("登陆态凭证")
    protected String sessionId;

    @ApiModelProperty("时间戳")
    private Long timestamp;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
