package com.rone.dao;

import com.rone.entity.LogonControl;
import com.rone.entity.LogonControlCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 登录
 *
 * @author rone
 */
@Mapper
public interface LogonControlMapper {
    long countByExample(LogonControlCriteria example);

    int deleteByExample(LogonControlCriteria example);

    int insert(LogonControl record);

    int insertSelective(LogonControl record);

    List<LogonControl> selectByExample(LogonControlCriteria example);

    int updateByExampleSelective(@Param("record") LogonControl record, @Param("example") LogonControlCriteria example);

    int updateByExample(@Param("record") LogonControl record, @Param("example") LogonControlCriteria example);

    /**
     * 根据openId查询最近的一条登陆记录
     *
     * @param openId
     * @return
     */
    LogonControl selectLastOneByOpenId(String openId);
}