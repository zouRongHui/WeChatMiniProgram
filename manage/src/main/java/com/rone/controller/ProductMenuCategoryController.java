package com.rone.controller;

import com.github.pagehelper.PageInfo;
import com.rone.entity.ProductMenu;
import com.rone.entity.ProductMenuCategory;
import com.rone.service.ProductMenuCategoryService;
import com.rone.service.ProductMenuService;
import com.rone.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 小程序产品菜单分类管理
 *
 * @author rone
 */
@Controller
@RequestMapping("productmenucategory")
public class ProductMenuCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMenuCategoryController.class);

    @Autowired
    private ProductMenuCategoryService productMenuCategoryService;
    @Autowired
    private ProductMenuService productMenuService;

    /**
     * 分页查询
     *
     * @param model
     * @param page         页码
     * @param size         每页展示条数
     * @param categoryName 分类名称
     * @return
     */
    @GetMapping("list")
    public String list(Model model, Integer page, Integer size, String categoryName) {
        if ((page == null || page == 0) || (size == null || size == 0)) {
            page = 1;
            size = 15;
        }
        PageInfo<ProductMenuCategory> pageInfo = productMenuCategoryService.getPageList(page, size, categoryName);
        model.addAttribute("productMenuCategoryList", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));
        return "productmenu/productmenu-category-list";
    }

    /**
     * 新增
     *
     * @return
     */
    @GetMapping("add")
    public String add() {
        return "productmenu/productmenu-category-add";
    }

    /**
     * 新增操作
     *
     * @param productMenuCategory 产品菜单分类信息
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addPost(ProductMenuCategory productMenuCategory) {
        JsonResult result = new JsonResult();
        productMenuCategoryService.add(productMenuCategory);
        result.setSuccess(true);
        result.setMsg("新增成功！");
        return result;
    }

    /**
     * 更新
     *
     * @param model
     * @param id    ID
     * @return
     */
    @GetMapping("edit")
    public String edit(Model model, Integer id) {
        ProductMenuCategory productMenuCategory = productMenuCategoryService.getById(id);
        model.addAttribute("productMenuCategory", productMenuCategory);
        return "productmenu/productmenu-category-edit";
    }

    /**
     * 更新操作
     *
     * @param productMenuCategory 产品菜单分类信息
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public JsonResult editPost(ProductMenuCategory productMenuCategory) {
        productMenuCategoryService.update(productMenuCategory);
        JsonResult result = new JsonResult();
        result.setMsg("更新成功！");
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除
     *
     * @param ids ID
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer... ids) {
        JsonResult result = new JsonResult();
        for (Integer id : ids) {
            List<ProductMenu> menuList = productMenuService.getByCategoryId(id);
            if (menuList != null && !menuList.isEmpty()) {
                result.setSuccess(false);
                result.setMsg("请先删除该分类下的产品菜单！");
                return result;
            }
        }
        productMenuCategoryService.delete(ids);
        result.setSuccess(true);
        result.setMsg("已删除！");
        return result;
    }


    /**
     * 排序操作
     *
     * @param id   编号
     * @param sort 排序
     * @return
     */
    @PostMapping("sort")
    @ResponseBody
    public JsonResult sortPost(Integer id, Integer sort) {
        JsonResult result = new JsonResult();
        ProductMenuCategory category = new ProductMenuCategory();
        category.setId(id);
        category.setSort(sort);
        productMenuCategoryService.update(category);
        result.setMsg("更新成功！");
        result.setSuccess(true);
        return result;
    }


}
