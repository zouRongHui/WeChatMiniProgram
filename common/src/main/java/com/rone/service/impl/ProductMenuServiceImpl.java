package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.ProductMenuMapper;
import com.rone.entity.ProductMenu;
import com.rone.entity.ProductMenuCriteria;
import com.rone.enumeration.YesOrNoEnum;
import com.rone.service.ProductMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 小程序产品菜单管理
 *
 * @author rone
 */
@Service
@Transactional
public class ProductMenuServiceImpl implements ProductMenuService {

    @Resource
    private ProductMenuMapper productMenuMapper;

    @Override
    public PageInfo<ProductMenu> getPageList(Integer page, Integer size, String menuName, Integer categoryId) {
        ProductMenuCriteria criteria = new ProductMenuCriteria();
        ProductMenuCriteria.Criteria menuCr = criteria.createCriteria();
        menuCr.andDeletedEqualTo("0");
        if (StringUtils.isNotBlank(menuName)) {
            menuCr.andMenuNameLike("%" + menuName + "%");
        }
        if (categoryId != null) {
            menuCr.andCategoryIdEqualTo(categoryId);
        }
        criteria.setOrderByClause(" sort ");
        PageHelper.startPage(page, size);
        List<ProductMenu> productMenuList = productMenuMapper.selectByExample(criteria);
        return new PageInfo<>(productMenuList);
    }

    @Override
    public void usable(Integer id) {
        ProductMenu productMenu = new ProductMenu();
        productMenu.setId(id);
        productMenu.setUpdateTime(new Date());
        productMenu.setUsable(YesOrNoEnum.YES.getCode().toString());
        productMenuMapper.updateByPrimaryKeySelective(productMenu);
    }

    @Override
    public void disable(Integer id) {
        ProductMenu productMenu = new ProductMenu();
        productMenu.setId(id);
        productMenu.setUpdateTime(new Date());
        productMenu.setUsable(YesOrNoEnum.NO.getCode().toString());
        productMenuMapper.updateByPrimaryKeySelective(productMenu);
    }

    @Override
    public void show(Integer id) {
        ProductMenu productMenu = new ProductMenu();
        productMenu.setId(id);
        productMenu.setUpdateTime(new Date());
        productMenu.setShowFirst(YesOrNoEnum.YES.getCode().toString());
        productMenuMapper.updateByPrimaryKeySelective(productMenu);
    }

    @Override
    public void hidden(Integer id) {
        ProductMenu productMenu = new ProductMenu();
        productMenu.setId(id);
        productMenu.setUpdateTime(new Date());
        productMenu.setShowFirst(YesOrNoEnum.NO.getCode().toString());
        productMenuMapper.updateByPrimaryKeySelective(productMenu);
    }

    @Override
    public List<ProductMenu> getByCategoryId(Integer categoryId) {
        ProductMenuCriteria criteria = new ProductMenuCriteria();
        criteria.createCriteria()
                .andCategoryIdEqualTo(categoryId)
                .andDeletedEqualTo("0");
        return productMenuMapper.selectByExample(criteria);
    }

    @Override
    public List<ProductMenu> getAll() {
        ProductMenuCriteria criteria = new ProductMenuCriteria();
        criteria.createCriteria().andDeletedEqualTo("0");
        criteria.setOrderByClause(" sort ");
        return productMenuMapper.selectByExample(criteria);
    }

    @Override
    public List<ProductMenu> getAllUsable() {
        ProductMenuCriteria criteria = new ProductMenuCriteria();
        criteria.createCriteria()
                .andDeletedEqualTo("0")
                .andUsableEqualTo(YesOrNoEnum.YES.getCode().toString());
        criteria.setOrderByClause(" sort ");
        return productMenuMapper.selectByExample(criteria);
    }

    @Override
    public ProductMenu add(ProductMenu productMenu) {
        ProductMenuCriteria criteria = new ProductMenuCriteria();
        criteria.createCriteria().andDeletedEqualTo("0");
        criteria.setOrderByClause(" sort desc ");
        List<ProductMenu> list = productMenuMapper.selectByExample(criteria);
        if (list == null || list.isEmpty()) {
            productMenu.setSort(1);
        } else {
            productMenu.setSort(list.get(0).getSort() + 1);
        }
        productMenu.setDeleted("0");
        productMenu.setCreateTime(new Date());
        // 默认不启用、首页不展示
        productMenu.setUsable(YesOrNoEnum.NO.getCode().toString());
        productMenu.setShowFirst(YesOrNoEnum.NO.getCode().toString());
        productMenuMapper.insertSelective(productMenu);
        return productMenu;
    }

    @Override
    public ProductMenu getById(Integer id) {
        return productMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProductMenu update(ProductMenu productMenu) {
        ProductMenu oldProductMenu = productMenuMapper.selectByPrimaryKey(productMenu.getId());

        if (oldProductMenu != null) {
            // 维护部分不需要更新的内容
            productMenu.setFontId(oldProductMenu.getFontId());
            productMenu.setSort(oldProductMenu.getSort());
            productMenu.setDeleted(oldProductMenu.getDeleted());
            productMenu.setCreateTime(oldProductMenu.getCreateTime());
            productMenu.setUpdateTime(new Date());
            productMenu.setUsable(oldProductMenu.getUsable());
            productMenu.setShowFirst(oldProductMenu.getShowFirst());
        }

        productMenuMapper.updateByPrimaryKey(productMenu);
        return productMenu;
    }

    @Override
    public ProductMenu sortUpdate(ProductMenu productMenu) {
        productMenuMapper.updateByPrimaryKeySelective(productMenu);
        return null;
    }

    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            ProductMenu productMenu = new ProductMenu();
            productMenu.setId(id);
            productMenu.setDeleted("1");
            productMenu.setUpdateTime(new Date());
            productMenuMapper.updateByPrimaryKeySelective(productMenu);
        }
    }
}
