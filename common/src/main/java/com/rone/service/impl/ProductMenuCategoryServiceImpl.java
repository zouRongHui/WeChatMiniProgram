package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.ProductMenuCategoryMapper;
import com.rone.entity.ProductMenuCategory;
import com.rone.entity.ProductMenuCategoryCriteria;
import com.rone.service.ProductMenuCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 小程序产品菜单分类管理
 *
 * @author rone
 */
@Service
@Transactional
public class ProductMenuCategoryServiceImpl implements ProductMenuCategoryService {

    @Resource
    private ProductMenuCategoryMapper productMenuCategoryMapper;

    @Override
    public PageInfo<ProductMenuCategory> getPageList(Integer page, Integer size, String categoryName) {
        ProductMenuCategoryCriteria criteria = new ProductMenuCategoryCriteria();
        ProductMenuCategoryCriteria.Criteria categoryCr = criteria.createCriteria();
        categoryCr.andDeletedEqualTo("0");
        if (StringUtils.isNotBlank(categoryName)) {
            categoryCr.andCategoryNameLike("%" + categoryName + "%");
        }
        criteria.setOrderByClause(" sort ");
        PageHelper.startPage(page, size);
        List<ProductMenuCategory> productMenuCategoryList = productMenuCategoryMapper.selectByExample(criteria);
        return new PageInfo<>(productMenuCategoryList);
    }

    @Override
    public List<ProductMenuCategory> getAll() {
        ProductMenuCategoryCriteria criteria = new ProductMenuCategoryCriteria();
        criteria.createCriteria().andDeletedEqualTo("0");
        criteria.setOrderByClause(" sort ");
        return productMenuCategoryMapper.selectByExample(criteria);
    }

    @Override
    public ProductMenuCategory add(ProductMenuCategory productMenuCategory) {
        ProductMenuCategoryCriteria criteria = new ProductMenuCategoryCriteria();
        criteria.createCriteria().andDeletedEqualTo("0");
        criteria.setOrderByClause(" sort desc ");
        List<ProductMenuCategory> list = productMenuCategoryMapper.selectByExample(criteria);
        if (list == null || list.isEmpty()) {
            productMenuCategory.setSort(1);
        } else {
            productMenuCategory.setSort(list.get(0).getSort() + 1);
        }
        productMenuCategory.setDeleted("0");
        productMenuCategory.setCreateTime(new Date());
        productMenuCategoryMapper.insertSelective(productMenuCategory);
        return productMenuCategory;
    }

    @Override
    public ProductMenuCategory getById(Integer id) {
        return productMenuCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProductMenuCategory update(ProductMenuCategory productMenuCategory) {
        productMenuCategory.setUpdateTime(new Date());
        productMenuCategoryMapper.updateByPrimaryKeySelective(productMenuCategory);
        return productMenuCategory;
    }

    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            ProductMenuCategory category = new ProductMenuCategory();
            category.setId(id);
            category.setDeleted("1");
            category.setUpdateTime(new Date());
            productMenuCategoryMapper.updateByPrimaryKeySelective(category);
        }
    }
}
