package com.rone.dao;

import com.rone.entity.RightsActivity;
import com.rone.entity.RightsActivityCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权益
 *
 * @author rone
 */
@Mapper
public interface RightsActivityMapper {
    long countByExample(RightsActivityCriteria example);

    int deleteByExample(RightsActivityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RightsActivity record);

    int insertSelective(RightsActivity record);

    List<RightsActivity> selectByExample(RightsActivityCriteria example);

    RightsActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RightsActivity record, @Param("example") RightsActivityCriteria example);

    int updateByExample(@Param("record") RightsActivity record, @Param("example") RightsActivityCriteria example);

    int updateByPrimaryKeySelective(RightsActivity record);

    int updateByPrimaryKey(RightsActivity record);

    /**
     * 通过主键获取行锁
     *
     * @param id
     * @return
     */
    RightsActivity lock(Integer id);
}