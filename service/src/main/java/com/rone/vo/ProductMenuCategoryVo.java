package com.rone.vo;

import com.rone.entity.ProductMenuCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品菜单分类表
 *
 * @author rone
 */
@ApiModel
public class ProductMenuCategoryVo {
    /**
     * ID
     */
    @ApiModelProperty("产品菜单分类编号")
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String categoryName;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String categoryDesc;
    /**
     * 展示风格（1横向  2竖向）
     */
    @ApiModelProperty("展示风格（1横向  2竖向）")
    private String showStyle;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    public ProductMenuCategoryVo() {
    }

    public ProductMenuCategoryVo(ProductMenuCategory productMenuCategory) {
        this.id = productMenuCategory.getId();
        this.categoryName = productMenuCategory.getCategoryName();
        this.categoryDesc = productMenuCategory.getCategoryDesc();
        this.showStyle = productMenuCategory.getShowStyle();
        this.sort = productMenuCategory.getSort();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }

    public String getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(String showStyle) {
        this.showStyle = showStyle == null ? null : showStyle.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}