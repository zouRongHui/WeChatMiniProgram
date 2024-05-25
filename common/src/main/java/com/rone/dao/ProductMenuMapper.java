package com.rone.dao;

import com.rone.entity.ProductMenu;
import com.rone.entity.ProductMenuCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品菜单
 *
 * @author rone
 */
@Mapper
public interface ProductMenuMapper {
    Integer countByExample(ProductMenuCriteria example);

    int deleteByExample(ProductMenuCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductMenu record);

    int insertSelective(ProductMenu record);

    List<ProductMenu> selectByExample(ProductMenuCriteria example);

    ProductMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductMenu record, @Param("example") ProductMenuCriteria example);

    int updateByExample(@Param("record") ProductMenu record, @Param("example") ProductMenuCriteria example);

    int updateByPrimaryKeySelective(ProductMenu record);

    int updateByPrimaryKey(ProductMenu record);
}