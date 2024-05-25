package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品菜单表
 *
 * @author rone
 */
public class ProductMenu implements Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String menuName;
    /**
     * 描述
     */
    private String productDesc;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 分类ID
     */
    private Integer categoryId;
    /**
     * 产品大类名称
     */
    private String categoryName;
    /**
     * 广告图地址
     */
    private String advertPhoto;
    /**
     * 可购页面
     */
    private String jumpUrl;
    /**
     * 可购页面参数
     */
    private String jumpParam;
    /**
     * 字体ID
     */
    private Integer fontId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否已删除（0否 1是）
     */
    private String deleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 负责人工号
     */
    private String consultWorkNo;
    /**
     * 业务种类
     */
    private String businessType;
    /**
     * 持有页面
     */
    private String holdUrl;
    /**
     * 持有页面参数
     */
    private String holdParam;
    /**
     * 是否启用，0：不启用；1：启用
     */
    private String usable;
    /**
     * 是否首页展示，0：不展示；1：展示
     */
    private String showFirst;
    /**
     * 查看时是否需要登陆，0:不需要;1:需要
     */
    private String needLogin;
    /**
     * 支持的用户类型，复选配置，英文逗号隔开，{@link com.rone.enumeration.UserInfoTypeEnum}
     */
    private String supportUserType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAdvertPhoto() {
        return advertPhoto;
    }

    public void setAdvertPhoto(String advertPhoto) {
        this.advertPhoto = advertPhoto == null ? null : advertPhoto.trim();
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
    }

    public String getJumpParam() {
        return jumpParam;
    }

    public void setJumpParam(String jumpParam) {
        this.jumpParam = jumpParam == null ? null : jumpParam.trim();
    }

    public Integer getFontId() {
        return fontId;
    }

    public void setFontId(Integer fontId) {
        this.fontId = fontId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getConsultWorkNo() {
        return consultWorkNo;
    }

    public void setConsultWorkNo(String consultWorkNo) {
        this.consultWorkNo = consultWorkNo == null ? null : consultWorkNo.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getHoldUrl() {
        return holdUrl;
    }

    public void setHoldUrl(String holdUrl) {
        this.holdUrl = holdUrl == null ? null : holdUrl.trim();
    }

    public String getHoldParam() {
        return holdParam;
    }

    public void setHoldParam(String holdParam) {
        this.holdParam = holdParam == null ? null : holdParam.trim();
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable == null ? null : usable.trim();
    }

    public String getShowFirst() {
        return showFirst;
    }

    public void setShowFirst(String showFirst) {
        this.showFirst = showFirst == null ? null : showFirst.trim();
    }

    public String getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(String needLogin) {
        this.needLogin = needLogin == null ? null : needLogin.trim();
    }

    public String getSupportUserType() {
        return supportUserType;
    }

    public void setSupportUserType(String supportUserType) {
        this.supportUserType = supportUserType;
    }
}