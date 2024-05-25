package com.rone.dao;

import com.rone.entity.MiniAppCode;
import com.rone.entity.MiniAppCodeCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小程序码
 *
 * @author rone
 */
@Mapper
public interface MiniAppCodeMapper {
    long countByExample(MiniAppCodeCriteria example);

    int deleteByExample(MiniAppCodeCriteria example);

    int insert(MiniAppCode record);

    int insertSelective(MiniAppCode record);

    List<MiniAppCode> selectByExample(MiniAppCodeCriteria example);

    int updateByExampleSelective(@Param("record") MiniAppCode record, @Param("example") MiniAppCodeCriteria example);

    int updateByExample(@Param("record") MiniAppCode record, @Param("example") MiniAppCodeCriteria example);
}