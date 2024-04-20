package com.rone.dao;

import com.rone.entity.BlockUser;
import com.rone.entity.BlockUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 黑名单用户
 *
 * @author rone
 */
@Mapper
public interface BlockUserMapper {
    long countByExample(BlockUserCriteria example);

    int deleteByExample(BlockUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BlockUser record);

    int insertSelective(BlockUser record);

    List<BlockUser> selectByExample(BlockUserCriteria example);

    BlockUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlockUser record, @Param("example") BlockUserCriteria example);

    int updateByExample(@Param("record") BlockUser record, @Param("example") BlockUserCriteria example);

    int updateByPrimaryKeySelective(BlockUser record);

    int updateByPrimaryKey(BlockUser record);

    /**
     * 根据 WD_USER_INFO 表的 WUI_CUST_NO 来组装 BlockUser
     *
     * @param userIdSet
     * @return
     */
    List<BlockUser> assembleByWdUserInfoId(@Param("set") Set<String> userIdSet);

}