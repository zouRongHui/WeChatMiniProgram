package com.rone.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 黑名单
 *
 * @author rone
 */
public class BlockUser implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 微信号open_id
     */
    private String openId;

    /**
     * 违反反欺诈规则
     */
    private String rule;

    /**
     * 加入黑名单时间
     */
    private Date createTime;

    /**
     * 状态，0:未启用;1:启用
     */
    private String status;

    /**
     * 最近修改时间
     */
    private Date editTime;

    /**
     * 添加者
     */
    private String creator;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlockUser blockUser = (BlockUser) o;
        return Objects.equals(phone, blockUser.phone) && Objects.equals(openId, blockUser.openId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, openId, rule, createTime, status, editTime, creator);
    }

}