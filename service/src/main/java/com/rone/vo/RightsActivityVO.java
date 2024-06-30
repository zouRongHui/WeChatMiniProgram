package com.rone.vo;

import com.rone.entity.RightsActivity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 权益活动
 *
 * @author rone
 */
public class RightsActivityVO {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("背景图片")
    private String imageBackground;
    @ApiModelProperty("logo图片")
    private String imageLogo;
    @ApiModelProperty("主标题")
    private String title;
    @ApiModelProperty("副标题")
    private String subtitle;
    @ApiModelProperty("介绍")
    private String introduce;
    @ApiModelProperty("数据状态，0:正常；1:活动已经结束")
    private Integer dataStatus;
    @ApiModelProperty("开始领取时间(hh:mm:ss)")
    private String startTime;
    @ApiModelProperty("领取截止时间(hh:mm:ss)")
    private String endTime;
    @ApiModelProperty("当前是否在可领取时间")
    private boolean receiveTimeAble;
    @ApiModelProperty("当前用户是否还有可领取次数")
    private boolean receiveUserNumAble;
    @ApiModelProperty("权益是否还有领取额度，总的领取额度是否还有")
    private boolean receiveTotalNumAble;
    @ApiModelProperty("当前用户是否有领取权限")
    private boolean receiveAuthAble;


    public RightsActivityVO() {
    }

    public RightsActivityVO(RightsActivity rightsActivity, boolean receiveTimeAble, boolean receiveUserNumAble, boolean receiveTotalNumAble, boolean receiveAuthAble) {
        this.id = rightsActivity.getId();
        this.imageBackground = rightsActivity.getImageBackground();
        this.imageLogo = rightsActivity.getImageLogo();
        this.title = rightsActivity.getTitle();
        this.subtitle = rightsActivity.getSubtitle();
        this.introduce = rightsActivity.getIntroduce();
        this.dataStatus = rightsActivity.getDeleteFlag();
        this.startTime = rightsActivity.getStartTime();
        this.endTime = rightsActivity.getEndTime();
        this.receiveTimeAble = receiveTimeAble;
        this.receiveUserNumAble = receiveUserNumAble;
        this.receiveTotalNumAble = receiveTotalNumAble;
        this.receiveAuthAble = receiveAuthAble;
    }

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
        this.imageBackground = imageBackground;
    }

    public String getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(String imageLogo) {
        this.imageLogo = imageLogo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
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

    public boolean isReceiveTimeAble() {
        return receiveTimeAble;
    }

    public void setReceiveTimeAble(boolean receiveTimeAble) {
        this.receiveTimeAble = receiveTimeAble;
    }

    public boolean isReceiveUserNumAble() {
        return receiveUserNumAble;
    }

    public void setReceiveUserNumAble(boolean receiveUserNumAble) {
        this.receiveUserNumAble = receiveUserNumAble;
    }

    public boolean isReceiveTotalNumAble() {
        return receiveTotalNumAble;
    }

    public void setReceiveTotalNumAble(boolean receiveTotalNumAble) {
        this.receiveTotalNumAble = receiveTotalNumAble;
    }

    public boolean isReceiveAuthAble() {
        return receiveAuthAble;
    }

    public void setReceiveAuthAble(boolean receiveAuthAble) {
        this.receiveAuthAble = receiveAuthAble;
    }
}
