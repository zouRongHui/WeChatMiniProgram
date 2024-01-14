package com.rone.dao;

import com.rone.entity.MenuInfo;
import com.rone.entity.MenuInfoCriteria;
import com.rone.entity.MenuTreeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 菜单
 *
 * @author rone
 */
@Mapper
public interface MenuInfoMapper {
    Integer countByExample(MenuInfoCriteria example);

    int deleteByExample(MenuInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    List<MenuInfo> selectByExample(MenuInfoCriteria example);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuInfo record, @Param("example") MenuInfoCriteria example);

    int updateByExample(@Param("record") MenuInfo record, @Param("example") MenuInfoCriteria example);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);

    /**
     * 获取菜单
     *
     * @return
     */
    List<MenuInfo> getRootTreeMenu();

    /**
     * 根据角色获取菜单
     *
     * @param roleId 角色ID
     * @return
     */
    List<MenuInfo> getRoleTreeMenu(@Param("roleId") Integer roleId);

    /**
     * 获取菜单树
     *
     * @return
     */
    List<MenuTreeInfo> getTree();

    /**
     * 根据角色获取权限
     *
     * @param roleId
     * @return
     */
    Set<String> getPermissionCodeByRole(Integer roleId);
}