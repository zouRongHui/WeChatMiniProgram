package com.rone.dao;

import com.rone.entity.RoleInfo;
import com.rone.entity.RoleInfoCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 *
 * @author rone
 */
@Mapper
public interface RoleInfoMapper {
    Integer countByExample(RoleInfoCriteria example);

    int deleteByExample(RoleInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    List<RoleInfo> selectByExample(RoleInfoCriteria example);

    RoleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoCriteria example);

    int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoCriteria example);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    int insertRoleMenu(@Param("menuIdList") List<Integer> menuIdList, @Param("roleId") Integer roleId);

    /**
     * 根据角色编号获取菜单编号集合
     *
     * @param roleId 角色ID
     * @return
     */
    List<Integer> selectMenuIdListByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据角色编号删除角色菜单中间表数据
     *
     * @param roleId
     * @return
     */
    int deleteRoleMenuByRoleId(@Param("roleId") Integer roleId);
}