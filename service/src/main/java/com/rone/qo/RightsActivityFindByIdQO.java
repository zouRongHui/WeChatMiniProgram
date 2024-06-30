package com.rone.qo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 获取权益信息的请求参数
 *
 * @author rone
 */
public class RightsActivityFindByIdQO extends CommonQO {
    @ApiModelProperty("权益ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
