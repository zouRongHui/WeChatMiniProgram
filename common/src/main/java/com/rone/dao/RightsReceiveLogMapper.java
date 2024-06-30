package com.rone.dao;

import com.rone.entity.RightsReceiveLog;
import com.rone.entity.RightsReceiveLogCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权益活动领取记录
 *
 * @author rone
 */
@Mapper
public interface RightsReceiveLogMapper {
    long countByExample(RightsReceiveLogCriteria example);

    int deleteByExample(RightsReceiveLogCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RightsReceiveLog record);

    int insertSelective(RightsReceiveLog record);

    List<RightsReceiveLog> selectByExample(RightsReceiveLogCriteria example);

    RightsReceiveLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RightsReceiveLog record, @Param("example") RightsReceiveLogCriteria example);

    int updateByExample(@Param("record") RightsReceiveLog record, @Param("example") RightsReceiveLogCriteria example);

    int updateByPrimaryKeySelective(RightsReceiveLog record);

    int updateByPrimaryKey(RightsReceiveLog record);
}