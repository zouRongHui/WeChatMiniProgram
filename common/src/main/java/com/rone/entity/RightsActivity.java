package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权益活动
 *
 * @author rone
 */
public class RightsActivity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 背景图片
     */
    private String imageBackground;

    /**
     * logo图片
     */
    private String imageLogo;

    /**
     * 主标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 权益id,商城权益接口所需参数
     */
    private String rightsId;

    /**
     * 权益生效时间(yyyy-MM-dd),商城权益接口所需参数
     */
    private String rightsStartDate;

    /**
     * 权益过期时间(yyyy-MM-dd),商城权益接口所需参数
     */
    private String rightsEndDate;

    /**
     * 权益次数即用户可领取次数,商城权益接口所需参数
     */
    private Integer rightsNum;

    /**
     * 单人可领取次数，0or为空时不限制
     */
    private Integer receiveTimesSingle;

    /**
     * 总领取次数，0or为空时不限制
     */
    private Integer receiveTimesTotal;

    /**
     * 权益已经被领取的次数
     */
    private Integer receiveTimesDone;

    /**
     * 剩余的领取次数
     */
    private Integer receiveTimesSurplus;

    /**
     * 状态，0:未启用;1:启用
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除标志，0:未删除;1:已删除
     */
    private Integer deleteFlag;

    /**
     * 活动开始日期，yyyy-MM-dd
     */
    private String startDate;

    /**
     * 活动截止日期，yyyy-MM-dd
     */
    private String endDate;

    /**
     * 领取开始时间，hh:mm:ss
     */
    private String startTime;

    /**
     * 领取截止时间，hh:mm:ss
     */
    private String endTime;

    /**
     * 领取周期，周一至周日，可多选，1:周一，2:周二....
     */
    private String receiveCycle;

    /**
     * 单人可领取次数的频率,{@link com.rone.enumeration.RightsActivityReceiveTimesSingleFrequencyEnum}
     */
    private String receiveTimesSingleFrequency;

    /**
     * 阶段权益总领取数量，0or为空时不限制
     */
    private Integer phaseRightsTotalNum;

    /**
     * 阶段频率(日、周、月、年),{@link com.rone.enumeration.RightsActivityPhaseRightsNumCycleEnum}
     */
    private String phaseRightsNumCycle;

    /**
     * 是否配置了白名单，0:否;1:是
     */
    private String hasAllowList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground == null ? null : imageBackground.trim();
    }

    public String getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(String imageLogo) {
        this.imageLogo = imageLogo == null ? null : imageLogo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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

    public Integer getReceiveTimesSingle() {
        return receiveTimesSingle;
    }

    public void setReceiveTimesSingle(Integer receiveTimesSingle) {
        this.receiveTimesSingle = receiveTimesSingle;
    }

    public Integer getReceiveTimesTotal() {
        return receiveTimesTotal;
    }

    public void setReceiveTimesTotal(Integer receiveTimesTotal) {
        this.receiveTimesTotal = receiveTimesTotal;
    }

    public Integer getReceiveTimesDone() {
        return receiveTimesDone;
    }

    public void setReceiveTimesDone(Integer receiveTimesDone) {
        this.receiveTimesDone = receiveTimesDone;
    }

    public Integer getReceiveTimesSurplus() {
        return receiveTimesSurplus;
    }

    public void setReceiveTimesSurplus(Integer receiveTimesSurplus) {
        this.receiveTimesSurplus = receiveTimesSurplus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReceiveCycle() {
        return receiveCycle;
    }

    public void setReceiveCycle(String receiveCycle) {
        this.receiveCycle = receiveCycle;
    }

    public String getReceiveTimesSingleFrequency() {
        return receiveTimesSingleFrequency;
    }

    public void setReceiveTimesSingleFrequency(String receiveTimesSingleFrequency) {
        this.receiveTimesSingleFrequency = receiveTimesSingleFrequency;
    }

    public Integer getPhaseRightsTotalNum() {
        return phaseRightsTotalNum;
    }

    public void setPhaseRightsTotalNum(Integer phaseRightsTotalNum) {
        this.phaseRightsTotalNum = phaseRightsTotalNum;
    }

    public String getPhaseRightsNumCycle() {
        return phaseRightsNumCycle;
    }

    public void setPhaseRightsNumCycle(String phaseRightsNumCycle) {
        this.phaseRightsNumCycle = phaseRightsNumCycle;
    }

    public String getHasAllowList() {
        return hasAllowList;
    }

    public void setHasAllowList(String hasAllowList) {
        this.hasAllowList = hasAllowList;
    }
}