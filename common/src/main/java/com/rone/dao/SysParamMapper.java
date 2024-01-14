package com.rone.dao;

import com.rone.entity.SysParam;
import com.rone.entity.SysParamCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统参数
 *
 * @author rone
 */
@Mapper
public interface SysParamMapper {
    Integer countByExample(SysParamCriteria example);

    int deleteByExample(SysParamCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    List<SysParam> selectByExample(SysParamCriteria example);

    SysParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamCriteria example);

    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamCriteria example);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKey(SysParam record);

    /**
     * 根据参数key获取系统参数值
     *
     * @param paramKey
     * @return
     */
    SysParam selectByParamKey(String paramKey);
}