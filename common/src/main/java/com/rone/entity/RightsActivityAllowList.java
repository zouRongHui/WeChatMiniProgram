package com.rone.entity;

import java.io.Serializable;

/**
 * 权益活动白名单
 *
 * @author rone
 */
public class RightsActivityAllowList implements Serializable {
    /**
     * 权益主键
     */
    private Integer rightsActivityId;

    /**
     * 手机号
     */
    private String phone;

    private static final long serialVersionUID = 1L;

    public Integer getRightsActivityId() {
        return rightsActivityId;
    }

    public void setRightsActivityId(Integer rightsActivityId) {
        this.rightsActivityId = rightsActivityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}