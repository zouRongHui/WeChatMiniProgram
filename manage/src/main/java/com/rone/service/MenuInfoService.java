package com.rone.service;

import com.rone.entity.MenuInfo;
import com.rone.entity.MenuTreeInfo;

import java.util.List;
import java.util.Set;

/**
 * 菜单权限
 *
 * @author rone
 */
public interface MenuInfoService {

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
    List<MenuInfo> getRoleTreeMenu(Integer roleId);

    /**
     * 获取菜单树
     *
     * @return
     */
    List<MenuTreeInfo> getTree();

    /**
     * 查询
     *
     * @param id 角色ID
     * @return
     */
    MenuInfo getById(Integer id);

    /**
     * 根据角色获取权限
     *
     * @param roleId
     * @return
     */
    Set<String> getPermissionCodeByRole(Integer roleId);
}
