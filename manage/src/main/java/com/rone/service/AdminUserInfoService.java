package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.AdminLoginLog;
import com.rone.entity.AdminUserInfo;

import java.util.Date;
import java.util.List;

/**
 * 用户管理
 *
 * @author rone
 */
public interface AdminUserInfoService {

    /**
     * 分页查询
     *
     * @param page     页码
     * @param size     每页展示条数
     * @param userName 用户名
     * @return
     */
    PageInfo<AdminUserInfo> getPageList(Integer page, Integer size, String userName);

    /**
     * 账号查询
     *
     * @param account 账号
     * @return
     */
    AdminUserInfo getByAccount(String account);

    /**
     * 查询
     *
     * @param id 用户ID
     * @return
     */
    AdminUserInfo getById(Integer id);

    /**
     * 新增
     *
     * @param adminUserInfo 用户信息
     * @return
     */
    AdminUserInfo add(AdminUserInfo adminUserInfo);

    /**
     * 修改
     *
     * @param adminUserInfo 用户信息
     * @return
     */
    AdminUserInfo update(AdminUserInfo adminUserInfo);

    /**
     * 停用
     *
     * @param id 用户ID
     * @return
     */
    AdminUserInfo stop(Integer id);

    /**
     * 启用
     *
     * @param id 用户ID
     * @return
     */
    AdminUserInfo start(Integer id);

    /**
     * 删除
     *
     * @param ids 用户ID
     */
    void delete(Integer... ids);

    /**
     * 根据角色ID查询
     *
     * @param roleId 角色ID
     * @return
     */
    List<AdminUserInfo> getByRoleId(Integer roleId);

    /**
     * 登记登陆日志
     *
     * @param loginLog
     * @return
     */
    int insertLoginLog(AdminLoginLog loginLog);

    /**
     * 获取规定时间内登陆错误的数据
     *
     * @param account
     * @param time
     * @return
     */
    List<AdminLoginLog> getFailLoginLogInTime(String account, Date time);
}
