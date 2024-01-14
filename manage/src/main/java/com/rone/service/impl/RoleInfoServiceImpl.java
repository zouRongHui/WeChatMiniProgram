package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.RoleInfoMapper;
import com.rone.entity.RoleInfo;
import com.rone.entity.RoleInfoCriteria;
import com.rone.service.IRoleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 角色管理
 *
 * @author rone
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements IRoleInfoService {

    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Override
    public PageInfo<RoleInfo> getPageList(Integer page, Integer size, String roleName) {
        RoleInfoCriteria criteria = new RoleInfoCriteria();
        RoleInfoCriteria.Criteria roleCr = criteria.createCriteria();
        roleCr.andDeletedEqualTo("0");
        if (StringUtils.isNotBlank(roleName)) {
            roleCr.andRoleNameLike("%" + roleName + "%");
        }
        criteria.setOrderByClause(" create_time desc ");
        PageHelper.startPage(page, size);
        List<RoleInfo> roleInfoList = roleInfoMapper.selectByExample(criteria);
        return new PageInfo<>(roleInfoList);
    }

    @Override
    public RoleInfo geyById(Integer id) {
        return roleInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RoleInfo> findAll() {
        RoleInfoCriteria criteria = new RoleInfoCriteria();
        criteria.createCriteria().andDeletedEqualTo("0");
        return roleInfoMapper.selectByExample(criteria);
    }

    @Override
    public RoleInfo add(RoleInfo roleInfo, List<Integer> menuIdList) {
        roleInfo.setDeleted("0");
        roleInfo.setCreateTime(new Date());
        roleInfoMapper.insertSelective(roleInfo);
        roleInfoMapper.insertRoleMenu(menuIdList, roleInfo.getId());
        return roleInfo;
    }

    @Override
    public List<Integer> selectMenuIdListByRoleId(Integer roleId) {
        return roleInfoMapper.selectMenuIdListByRoleId(roleId);
    }

    @Override
    public RoleInfo update(RoleInfo roleInfo, List<Integer> menuIdList) {
        roleInfoMapper.deleteRoleMenuByRoleId(roleInfo.getId());
        roleInfo.setUpdateTime(new Date());
        roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
        roleInfoMapper.insertRoleMenu(menuIdList, roleInfo.getId());
        return roleInfo;
    }


    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setId(id);
            roleInfo.setDeleted("1");
            roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
            roleInfoMapper.deleteRoleMenuByRoleId(id);
        }
    }
}
