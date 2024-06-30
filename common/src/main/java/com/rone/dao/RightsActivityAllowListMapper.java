package com.rone.dao;

import com.rone.entity.RightsActivityAllowList;
import com.rone.entity.RightsActivityAllowListCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权益白名单
 *
 * @author rone
 */
@Mapper
public interface RightsActivityAllowListMapper {
    long countByExample(RightsActivityAllowListCriteria example);

    int deleteByExample(RightsActivityAllowListCriteria example);

    int insert(RightsActivityAllowList record);

    int insertSelective(RightsActivityAllowList record);

    List<RightsActivityAllowList> selectByExample(RightsActivityAllowListCriteria example);

    int updateByExampleSelective(@Param("record") RightsActivityAllowList record, @Param("example") RightsActivityAllowListCriteria example);

    int updateByExample(@Param("record") RightsActivityAllowList record, @Param("example") RightsActivityAllowListCriteria example);

    /**
     * 批量新增
     *
     * @param rightsActivityAllowListList
     * @return
     */
    int batchInsert(@Param("list") List<RightsActivityAllowList> rightsActivityAllowListList);
}