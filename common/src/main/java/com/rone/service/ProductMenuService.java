package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.ProductMenu;

import java.util.List;

/**
 * 小程序产品菜单管理
 *
 * @author rone
 */
public interface ProductMenuService {

    /**
     * 分页查询
     *
     * @param page       页码
     * @param size       每页展示条数
     * @param menuName   菜单名称
     * @param categoryId 分类ID
     * @return
     */
    PageInfo<ProductMenu> getPageList(Integer page, Integer size, String menuName, Integer categoryId);

    /**
     * 启用
     *
     * @param id
     */
    void usable(Integer id);

    /**
     * 禁用
     *
     * @param id
     */
    void disable(Integer id);

    /**
     * 首页展示
     *
     * @param id
     */
    void show(Integer id);

    /**
     * 首页隐藏
     *
     * @param id
     */
    void hidden(Integer id);

    /**
     * 根据分类查询
     *
     * @param categoryId 分类ID
     * @return
     */
    List<ProductMenu> getByCategoryId(Integer categoryId);

    /**
     * 查询所有
     *
     * @return
     */
    List<ProductMenu> getAll();

    /**
     * 查询所有启用的产品菜单
     *
     * @return
     */
    List<ProductMenu> getAllUsable();

    /**
     * 新增
     *
     * @param productMenu 产品菜单信息
     * @return
     */
    ProductMenu add(ProductMenu productMenu);

    /**
     * 查询
     *
     * @param id 编号
     * @return
     */
    ProductMenu getById(Integer id);

    /**
     * 修改
     *
     * @param productMenu 产品菜单信息
     * @return
     */
    ProductMenu update(ProductMenu productMenu);

    /**
     * 排序的更新
     *
     * @param productMenu
     * @return
     */
    ProductMenu sortUpdate(ProductMenu productMenu);

    /**
     * 删除
     *
     * @param ids 编号
     */
    void delete(Integer... ids);
}
