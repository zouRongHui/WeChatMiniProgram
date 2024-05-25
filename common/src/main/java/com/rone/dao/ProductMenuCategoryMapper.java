package com.rone.dao;

import com.rone.entity.ProductMenuCategory;
import com.rone.entity.ProductMenuCategoryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品菜单类别
 *
 * @author rone
 */
@Mapper
public interface ProductMenuCategoryMapper {
    Integer countByExample(ProductMenuCategoryCriteria example);

    int deleteByExample(ProductMenuCategoryCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductMenuCategory record);

    int insertSelective(ProductMenuCategory record);

    List<ProductMenuCategory> selectByExample(ProductMenuCategoryCriteria example);

    ProductMenuCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductMenuCategory record, @Param("example") ProductMenuCategoryCriteria example);

    int updateByExample(@Param("record") ProductMenuCategory record, @Param("example") ProductMenuCategoryCriteria example);

    int updateByPrimaryKeySelective(ProductMenuCategory record);

    int updateByPrimaryKey(ProductMenuCategory record);
}