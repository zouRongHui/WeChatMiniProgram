package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.ProductMenuCategory;

import java.util.List;

/**
 * 小程序产品菜单分类管理
 *
 * @author rone
 */
public interface ProductMenuCategoryService {

    /**
     * 分页查询
     *
     * @param page         页码
     * @param size         每页展示条数
     * @param categoryName 分类名称
     * @return
     */
    PageInfo<ProductMenuCategory> getPageList(Integer page, Integer size, String categoryName);

    /**
     * 查询所有
     *
     * @return
     */
    List<ProductMenuCategory> getAll();

    /**
     * 新增
     *
     * @param productMenuCategory 产品菜单分类信息
     * @return
     */
    ProductMenuCategory add(ProductMenuCategory productMenuCategory);

    /**
     * 根据编号查询
     *
     * @param id 编号
     * @return
     */
    ProductMenuCategory getById(Integer id);

    /**
     * 修改
     *
     * @param productMenuCategory 产品菜单分类信息
     * @return
     */
    ProductMenuCategory update(ProductMenuCategory productMenuCategory);

    /**
     * 删除
     *
     * @param ids 编号
     */
    void delete(Integer... ids);

}
