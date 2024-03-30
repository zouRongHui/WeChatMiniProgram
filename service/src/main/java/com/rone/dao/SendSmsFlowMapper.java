package com.rone.dao;

import com.rone.entity.SendSmsFlow;
import com.rone.entity.SendSmsFlowCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 发短信
 *
 * @author rone
 */
@Mapper
public interface SendSmsFlowMapper {
    long countByExample(SendSmsFlowCriteria example);

    int deleteByExample(SendSmsFlowCriteria example);

    int insert(SendSmsFlow record);

    int insertSelective(SendSmsFlow record);

    List<SendSmsFlow> selectByExample(SendSmsFlowCriteria example);

    int updateByExampleSelective(@Param("record") SendSmsFlow record, @Param("example") SendSmsFlowCriteria example);

    int updateByExample(@Param("record") SendSmsFlow record, @Param("example") SendSmsFlowCriteria example);
}