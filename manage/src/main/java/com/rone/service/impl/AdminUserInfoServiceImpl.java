package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.AdminUserInfoMapper;
import com.rone.entity.AdminLoginLog;
import com.rone.entity.AdminUserInfo;
import com.rone.entity.AdminUserInfoCriteria;
import com.rone.enumeration.UserInfoStatusEnum;
import com.rone.service.AdminUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 *
 * @author rone
 */
@Service
@Transactional
public class AdminUserInfoServiceImpl implements AdminUserInfoService {

    @Resource
    private AdminUserInfoMapper adminUserInfoMapper;

    @Override
    public PageInfo<AdminUserInfo> getPageList(Integer page, Integer size, String userName) {
        PageHelper.startPage(page, size);
        List<AdminUserInfo> adminUserInfoList = adminUserInfoMapper.getPageList(userName);
        return new PageInfo<>(adminUserInfoList);
    }

    @Override
    public AdminUserInfo getByAccount(String account) {
        AdminUserInfoCriteria criteria = new AdminUserInfoCriteria();
        criteria.createCriteria()
                .andAccountEqualTo(account)
                .andStartedEqualTo("1");
        List<AdminUserInfo> adminUserInfoList = adminUserInfoMapper.selectByExample(criteria);
        if (adminUserInfoList != null && !adminUserInfoList.isEmpty()) {
            return adminUserInfoList.get(0);
        }
        return null;
    }

    @Override
    public AdminUserInfo getById(Integer id) {
        return adminUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public AdminUserInfo add(AdminUserInfo adminUserInfo) {
        adminUserInfo.setStatus(UserInfoStatusEnum.NORMAL.getCode());
        adminUserInfo.setTempLockInvalidTime(null);
        adminUserInfoMapper.insertSelective(adminUserInfo);
        return adminUserInfo;
    }

    @Override
    public AdminUserInfo update(AdminUserInfo adminUserInfo) {
        adminUserInfo.setUpdateTime(new Date());
        adminUserInfoMapper.updateByPrimaryKeySelective(adminUserInfo);
        return adminUserInfo;
    }

    @Override
    public AdminUserInfo stop(Integer id) {
        AdminUserInfo adminUserInfo = new AdminUserInfo();
        adminUserInfo.setId(id);
        adminUserInfo.setUpdateTime(new Date());
        adminUserInfo.setStarted("0");
        adminUserInfoMapper.updateByPrimaryKeySelective(adminUserInfo);
        return adminUserInfo;
    }

    @Override
    public AdminUserInfo start(Integer id) {
        AdminUserInfo adminUserInfo = new AdminUserInfo();
        adminUserInfo.setId(id);
        adminUserInfo.setUpdateTime(new Date());
        adminUserInfo.setStarted("1");
        adminUserInfo.setStatus(UserInfoStatusEnum.NORMAL.getCode());
        adminUserInfo.setTempLockInvalidTime(null);
        adminUserInfoMapper.updateByPrimaryKeySelective(adminUserInfo);
        return adminUserInfo;
    }

    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            adminUserInfoMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<AdminUserInfo> getByRoleId(Integer roleId) {
        AdminUserInfoCriteria criteria = new AdminUserInfoCriteria();
        criteria.createCriteria().andRoleIdEqualTo(roleId);
        return adminUserInfoMapper.selectByExample(criteria);
    }

    @Override
    public int insertLoginLog(AdminLoginLog loginLog) {
        if (loginLog == null) {
            return 0;
        }
        return adminUserInfoMapper.insertLoginLog(loginLog);
    }

    @Override
    public List<AdminLoginLog> getFailLoginLogInTime(String account, Date time) {
        return adminUserInfoMapper.getFailLoginLogInTime(account, time);
    }
}
