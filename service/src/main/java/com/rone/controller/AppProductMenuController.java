package com.rone.controller;

import com.rone.entity.ProductMenu;
import com.rone.entity.ProductMenuCategory;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.service.ProductMenuCategoryService;
import com.rone.service.ProductMenuService;
import com.rone.service.SysParamService;
import com.rone.vo.ProductMenuCategoryVo;
import com.rone.vo.ProductMenuVo;
import com.rone.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 小程序产品菜单
 *
 * @author rone
 */
@RestController
@RequestMapping("productmenu")
@Api(value = "小程序产品菜单", description = "小程序产品菜单")
public class AppProductMenuController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppProductMenuController.class);

    @Autowired
    private ProductMenuCategoryService productMenuCategoryService;
    @Autowired
    private ProductMenuService productMenuService;
    @Autowired
    private SysParamService sysParamService;

    /**
     * 查询所有产品菜单信息
     *
     * @return
     */
    @PostMapping("getall")
    @ApiOperation(value = "查询所有产品菜单信息")
    public Result<ProductMenuVo> getAll() {
        List<ProductMenu> productMenuList = productMenuService.getAllUsable();
        ProductMenuVo productMenuVo = new ProductMenuVo();
        int swiperInterval = -1;
        try {
            swiperInterval = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.INDEX_SWIPER_INTERVAL.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("小程序首页轮播图自动切换间隔参数获取错误", e);
        }
        productMenuVo.setUseSwiper(swiperInterval > 0);
        productMenuVo.setSwiperInterval(swiperInterval);
        // 页面默认值
        int navigationDistance = 35;
        try {
            navigationDistance = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.INDEX_NAVIGATION_DISTANCE.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("小程序首页轮播图导航栏间距参数获取错误", e);
        }
        productMenuVo.setNavigationDistance(navigationDistance);
        if (productMenuList != null && productMenuList.size() > 0) {
            ArrayList<ProductMenuVo.Data> productMenuVoDataList = new ArrayList<>(productMenuList.size());
            for (ProductMenu productMenu : productMenuList) {
                productMenu.setAdvertPhoto(productMenu.getAdvertPhoto());
                productMenu.setMenuIcon(productMenu.getMenuIcon());
                ProductMenuVo.Data data = new ProductMenuVo.Data(productMenu);
                productMenuVoDataList.add(data);
            }
            productMenuVo.setData(productMenuVoDataList);
            return Result.success(productMenuVo);
        }
        return Result.fault("记录不存在");
    }

    /**
     * 查询所有菜单分类
     *
     * @return
     */
    @PostMapping("getallcategory")
    @ApiOperation(value = "查询所有菜单分类")
    public Result<List<ProductMenuCategoryVo>> getAllCategory() {
        List<ProductMenuCategory> categoryList = productMenuCategoryService.getAll();
        if (categoryList != null && categoryList.size() > 0) {
            ArrayList<ProductMenuCategoryVo> productMenuCategoryVos = new ArrayList<>();
            for (ProductMenuCategory productMenuCategory : categoryList) {
                ProductMenuCategoryVo vo = new ProductMenuCategoryVo(productMenuCategory);
                productMenuCategoryVos.add(vo);
            }
            return Result.success(productMenuCategoryVos);
        }
        return Result.fault("记录不存在");
    }

}
