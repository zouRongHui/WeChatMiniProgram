package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.RoleInfo;

import java.util.List;

/**
 * 角色管理
 *
 * @author rone
 */
public interface IRoleInfoService {

    /**
     * 分页查询
     *
     * @param page     页码
     * @param size     每页展示条数
     * @param roleName 角色名称
     * @return
     */
    PageInfo<RoleInfo> getPageList(Integer page, Integer size, String roleName);

    /**
     * 查询
     *
     * @param id 角色ID
     * @return
     */
    RoleInfo geyById(Integer id);


    /**
     * 查询所有角色
     *
     * @return
     */
    List<RoleInfo> findAll();

    /**
     * 新增
     *
     * @param roleInfo   角色信息
     * @param menuIdList 菜单ID集合
     * @return
     */
    RoleInfo add(RoleInfo roleInfo, List<Integer> menuIdList);

    /**
     * 根据角色编号获取菜单编号集合
     *
     * @param roleId 角色ID
     * @return
     */
    List<Integer> selectMenuIdListByRoleId(Integer roleId);

    /**
     * 更新
     *
     * @param roleInfo   角色信息
     * @param menuIdList 菜单ID集合
     * @return
     */
    RoleInfo update(RoleInfo roleInfo, List<Integer> menuIdList);

    /**
     * 删除
     *
     * @param ids 角色ID
     */
    void delete(Integer... ids);

}
