package com.rone.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 管理用户表
 *
 * @author rone
 */
public class AdminUserInfo implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 是否启用（0关闭 1开启）
     */
    private String started;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 用户状态，{@link com.rone.enumeration.UserInfoStatusEnum}
     */
    private String status;

    /**
     * 账号临时锁定失效时间
     */
    private Date tempLockInvalidTime;

    /**
     * 用户权限集合
     */
    private Set<String> permissionCodeSet;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started == null ? null : started.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTempLockInvalidTime() {
        return tempLockInvalidTime;
    }

    public void setTempLockInvalidTime(Date tempLockInvalidTime) {
        this.tempLockInvalidTime = tempLockInvalidTime;
    }

    public Set<String> getPermissionCodeSet() {
        return permissionCodeSet;
    }

    public void setPermissionCodeSet(Set<String> permissionCodeSet) {
        this.permissionCodeSet = permissionCodeSet;
    }
}