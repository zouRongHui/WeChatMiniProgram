package com.rone.vo;

import com.rone.entity.ProductMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

/**
 * 产品菜单表
 *
 * @author rone
 */
@ApiModel
public class ProductMenuVo {
    @ApiModelProperty("轮播图时间间隔")
    private Integer swiperInterval;
    @ApiModelProperty("轮播图是否自动轮播")
    private Boolean useSwiper;
    @ApiModelProperty("轮播图导航栏间距")
    private Integer navigationDistance;
    @ApiModelProperty("产品菜单数据")
    private List<Data> data;

    public ProductMenuVo() {
    }

    public Boolean getUseSwiper() {
        return useSwiper;
    }

    public void setUseSwiper(Boolean useSwiper) {
        this.useSwiper = useSwiper;
    }

    public Integer getNavigationDistance() {
        return navigationDistance;
    }

    public void setNavigationDistance(Integer navigationDistance) {
        this.navigationDistance = navigationDistance;
    }

    public Integer getSwiperInterval() {
        return swiperInterval;
    }

    public void setSwiperInterval(Integer swiperInterval) {
        this.swiperInterval = swiperInterval;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    /**
     * 具体的产品数据
     */
    public static class Data {

        public static final Logger LOGGER = LoggerFactory.getLogger(Data.class);
        /**
         * ID
         */
        @ApiModelProperty("产品菜单编号")
        private Integer id;
        /**
         * 名称
         */
        @ApiModelProperty("名称")
        private String menuName;
        /**
         * 描述
         */
        @ApiModelProperty("描述")
        private String productDesc;
        /**
         * 菜单图标
         */
        @ApiModelProperty("菜单图标")
        private String menuIcon;
        /**
         * 分类ID
         */
        @ApiModelProperty("分类ID")
        private Integer categoryId;
        /**
         * 广告图地址
         */
        @ApiModelProperty("广告图地址")
        private String advertPhoto;
        /**
         * 跳转URL
         */
        @ApiModelProperty("跳转URL")
        private String jumpUrl;
        /**
         * 跳转参数
         */
        @ApiModelProperty("跳转参数")
        private String jumpParam;
        /**
         * 字体ID
         */
        @ApiModelProperty("字体ID")
        private Integer fontId;
        /**
         * 排序
         */
        @ApiModelProperty("排序")
        private Integer sort;
        /**
         * 负责人工号
         */
        @ApiModelProperty("负责人工号（多个工号以 # 井号符隔开）")
        private String consultWorkNo;
        /**
         * 首页是否展示，0:不展示；1:展示
         */
        @ApiModelProperty("首页是否展示，0:不展示；1:展示")
        private Integer showInIndex;
        @ApiModelProperty("查看时是否需要登陆，0:不需要;1:需要")
        private String needLogin;
        @ApiModelProperty("支持的用户类型，仅当包含客户信息中 userType 字段的值时才允许用户操作")
        private String supportUserType;

        public Data() {
        }

        public Data(ProductMenu productMenu) {
            this.id = productMenu.getId();
            this.menuName = productMenu.getMenuName();
            this.productDesc = productMenu.getProductDesc();
            this.menuIcon = productMenu.getMenuIcon();
            this.categoryId = productMenu.getCategoryId();
            this.advertPhoto = productMenu.getAdvertPhoto();
            this.jumpUrl = productMenu.getJumpUrl();
            this.jumpParam = productMenu.getJumpParam();
            this.fontId = productMenu.getFontId();
            this.sort = productMenu.getSort();
            if (StringUtils.isNotEmpty(productMenu.getConsultWorkNo())) {
                String[] consultWorkNos = productMenu.getConsultWorkNo().split("#");
                int index = (new Random()).nextInt(consultWorkNos.length);
                this.consultWorkNo = consultWorkNos[index];
            }
            int showInIndex;
            try {
                showInIndex = Integer.parseInt(productMenu.getShowFirst());
            } catch (NumberFormatException e) {
                LOGGER.error("获取产品是否首页展示字段异常，产品ID：{}", productMenu.getId(), e);
                showInIndex = 0;
            }
            this.showInIndex = showInIndex;
            this.needLogin = productMenu.getNeedLogin();
            this.supportUserType = productMenu.getSupportUserType();
        }

        public Integer getShowInIndex() {
            return showInIndex;
        }

        public void setShowInIndex(Integer showInIndex) {
            this.showInIndex = showInIndex;
        }

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
            this.menuName = menuName;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        public String getMenuIcon() {
            return menuIcon;
        }

        public void setMenuIcon(String menuIcon) {
            this.menuIcon = menuIcon;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getAdvertPhoto() {
            return advertPhoto;
        }

        public void setAdvertPhoto(String advertPhoto) {
            this.advertPhoto = advertPhoto;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public String getJumpParam() {
            return jumpParam;
        }

        public void setJumpParam(String jumpParam) {
            this.jumpParam = jumpParam;
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

        public String getConsultWorkNo() {
            return consultWorkNo;
        }

        public void setConsultWorkNo(String consultWorkNo) {
            this.consultWorkNo = consultWorkNo;
        }

        public String getNeedLogin() {
            return needLogin;
        }

        public void setNeedLogin(String needLogin) {
            this.needLogin = needLogin;
        }

        public String getSupportUserType() {
            return supportUserType;
        }

        public void setSupportUserType(String supportUserType) {
            this.supportUserType = supportUserType;
        }
    }

}