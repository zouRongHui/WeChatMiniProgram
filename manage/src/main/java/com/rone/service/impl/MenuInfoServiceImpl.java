package com.rone.service.impl;

import com.rone.dao.MenuInfoMapper;
import com.rone.entity.MenuInfo;
import com.rone.entity.MenuTreeInfo;
import com.rone.service.MenuInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 菜单权限
 *
 * @author rone
 */
@Service
@Transactional
public class MenuInfoServiceImpl implements MenuInfoService {

    @Resource
    private MenuInfoMapper menuInfoMapper;

    @Override
    public List<MenuInfo> getRootTreeMenu() {
        return menuInfoMapper.getRootTreeMenu();
    }

    @Override
    public List<MenuInfo> getRoleTreeMenu(Integer roleId) {
        return menuInfoMapper.getRoleTreeMenu(roleId);
    }

    @Override
    public List<MenuTreeInfo> getTree() {
        return menuInfoMapper.getTree();
    }

    @Override
    public MenuInfo getById(Integer id) {
        return menuInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Set<String> getPermissionCodeByRole(Integer roleId) {
        return menuInfoMapper.getPermissionCodeByRole(roleId);
    }
}
