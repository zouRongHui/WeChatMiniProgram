package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权益活动领取记录
 *
 * @author rone
 */
public class RightsReceiveLog implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户微信id
     */
    private String openId;

    /**
     * 用户手机
     */
    private String phone;

    /**
     * 权益ID
     */
    private String rightsId;

    /**
     * 权益生效时间(yyyy-MM-dd),本日期0点之后才可以领取
     */
    private String rightsStartDate;

    /**
     * 权益过期时间(yyyy-MM-dd),本日期23:59:59之后不能再领取(领取类型权益专属字段)
     */
    private String rightsEndDate;

    /**
     * 权益次数即用户可领取次数,最小值1,最大值99
     */
    private Integer rightsNum;

    /**
     * 领取时间
     */
    private Date receiveTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRightsId() {
        return rightsId;
    }

    public void setRightsId(String rightsId) {
        this.rightsId = rightsId == null ? null : rightsId.trim();
    }

    public String getRightsStartDate() {
        return rightsStartDate;
    }

    public void setRightsStartDate(String rightsStartDate) {
        this.rightsStartDate = rightsStartDate == null ? null : rightsStartDate.trim();
    }

    public String getRightsEndDate() {
        return rightsEndDate;
    }

    public void setRightsEndDate(String rightsEndDate) {
        this.rightsEndDate = rightsEndDate == null ? null : rightsEndDate.trim();
    }

    public Integer getRightsNum() {
        return rightsNum;
    }

    public void setRightsNum(Integer rightsNum) {
        this.rightsNum = rightsNum;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}