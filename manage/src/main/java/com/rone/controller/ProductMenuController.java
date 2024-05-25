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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序产品菜单管理
 *
 * @author rone
 */
@Controller
@RequestMapping("productmenu")
public class ProductMenuController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMenuController.class);

    @Autowired
    private ProductMenuCategoryService productMenuCategoryService;
    @Autowired
    private ProductMenuService productMenuService;

    /**
     * 分页查询
     *
     * @param model
     * @param page       页码
     * @param size       每页展示条数
     * @param menuName   菜单名称
     * @param categoryId 分类ID
     * @return
     */
    @GetMapping("list")
    public String list(Model model, Integer page, Integer size, String menuName, Integer categoryId) {
        if ((page == null || page == 0) || (size == null || size == 0)) {
            page = 1;
            size = 15;
        }
        PageInfo<ProductMenu> pageInfo = productMenuService.getPageList(page, size, menuName, categoryId);
        List<ProductMenuCategory> categoryList = productMenuCategoryService.getAll();
        Map<Integer, ProductMenuCategory> productMenuCategoryMap = new HashMap<>();
        for (ProductMenuCategory productMenuCategory : categoryList) {
            productMenuCategoryMap.put(productMenuCategory.getId(), productMenuCategory);
        }
        for (ProductMenu productMenu : pageInfo.getList()) {
            productMenu.setCategoryName(productMenuCategoryMap.get(productMenu.getCategoryId()) == null ? "" : productMenuCategoryMap.get(productMenu.getCategoryId()).getCategoryName());
        }
        model.addAttribute("productMenuList", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("menuName", menuName);
        model.addAttribute("categoryId", categoryId);
        return "productmenu/productmenu-list";
    }

    /**
     * 启用
     *
     * @param id ID
     * @return
     */
    @PostMapping("usable")
    @ResponseBody
    public JsonResult usable(Integer id) {
        productMenuService.usable(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已启用！");
        return result;
    }

    /**
     * 禁用
     *
     * @param id ID
     * @return
     */
    @PostMapping("disable")
    @ResponseBody
    public JsonResult disable(Integer id) {
        productMenuService.disable(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已禁用！");
        return result;
    }

    /**
     * 展示
     *
     * @param id ID
     * @return
     */
    @PostMapping("show")
    @ResponseBody
    public JsonResult show(Integer id) {
        productMenuService.show(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已展示！");
        return result;
    }

    /**
     * 隐藏
     *
     * @param id ID
     * @return
     */
    @PostMapping("hidden")
    @ResponseBody
    public JsonResult hidden(Integer id) {
        productMenuService.hidden(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已隐藏！");
        return result;
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model) {
        List<ProductMenuCategory> categoryList = productMenuCategoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "productmenu/productmenu-add";
    }

    /**
     * 新增操作
     *
     * @param productMenu 产品菜单信息
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addPost(ProductMenu productMenu) {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        productMenuService.add(productMenu);
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
        ProductMenu productMenu = productMenuService.getById(id);
        model.addAttribute("productMenu", productMenu);
        List<ProductMenuCategory> categoryList = productMenuCategoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "productmenu/productmenu-edit";
    }

    /**
     * 更新操作
     *
     * @param productMenu 产品菜单信息
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public JsonResult editPost(ProductMenu productMenu) {
        JsonResult result = new JsonResult();
        productMenuService.update(productMenu);
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
        productMenuService.delete(ids);
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
        ProductMenu productMenu = new ProductMenu();
        productMenu.setId(id);
        productMenu.setSort(sort);
        productMenuService.sortUpdate(productMenu);
        result.setMsg("更新成功！");
        result.setSuccess(true);
        return result;
    }

}
