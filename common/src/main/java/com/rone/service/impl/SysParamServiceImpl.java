package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.SysParamMapper;
import com.rone.entity.SysParam;
import com.rone.entity.SysParamCriteria;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.service.SysParamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统参数管理
 *
 * @author rone
 */
@Service
@Transactional
public class SysParamServiceImpl implements SysParamService {

    @Resource
    private SysParamMapper sysParamMapper;

    @Override
    public PageInfo<SysParam> getPageList(Integer page, Integer size, String paramKey, String paramName) {
        SysParamCriteria criteria = new SysParamCriteria();
        criteria.setOrderByClause(" create_time desc ");
        SysParamCriteria.Criteria sysCr = criteria.createCriteria();
        sysCr.andDeletedEqualTo("0");
        if (StringUtils.isNotBlank(paramKey)) {
            sysCr.andParamKeyLike("%" + paramKey + "%");
        }
        if (StringUtils.isNotBlank(paramName)) {
            sysCr.andParamNameLike("%" + paramName + "%");
        }
        PageHelper.startPage(page, size);
        List<SysParam> sysParamList = sysParamMapper.selectByExample(criteria);
        return new PageInfo<>(sysParamList);
    }

    @Override
    public SysParam add(SysParam sysParam) {
        sysParamMapper.insertSelective(sysParam);
        return sysParam;
    }

    @Override
    public SysParam getById(Integer id) {
        return sysParamMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysParam update(SysParam sysParam) {
        sysParam.setUpdateTime(new Date());
        sysParamMapper.updateByPrimaryKeySelective(sysParam);
        return sysParam;
    }

    @Override
    public SysParam stop(Integer id) {
        SysParam sysParam = new SysParam();
        sysParam.setId(id);
        sysParam.setStatus("1");
        sysParam.setUpdateTime(new Date());
        sysParamMapper.updateByPrimaryKeySelective(sysParam);
        return sysParam;
    }

    @Override
    public SysParam start(Integer id) {
        SysParam sysParam = new SysParam();
        sysParam.setId(id);
        sysParam.setStatus("0");
        sysParam.setUpdateTime(new Date());
        sysParamMapper.updateByPrimaryKeySelective(sysParam);
        return sysParam;
    }

    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            SysParam sysParam = new SysParam();
            sysParam.setId(id);
            sysParam.setDeleted("1");
            sysParam.setUpdateTime(new Date());
            sysParamMapper.updateByPrimaryKeySelective(sysParam);
        }
    }

    @Override
    public String getSysParamValue(String paramKey) {
        SysParam sysParam = sysParamMapper.selectByParamKey(paramKey);
        return sysParam == null ? null : sysParam.getParamValue();
    }

    @Override
    public int updateSysParamValueByKey(String paramKey, String paramValue) {
        SysParam sysParam = sysParamMapper.selectByParamKey(paramKey);
        sysParam.setParamValue(paramValue);
        sysParam.setUpdateTime(new Date());
        return sysParamMapper.updateByPrimaryKey(sysParam);
    }

    @Override
    public String getSysParamValue(SystemParamKeyEnum paramKeyEnum) {
        if (paramKeyEnum == null) {
            return null;
        }
        SysParam sysParam = sysParamMapper.selectByParamKey(paramKeyEnum.getCode());
        if (sysParam == null) {
            return paramKeyEnum.getDefaultValue();
        } else {
            return sysParam.getParamValue();
        }
    }

    @Override
    public Integer getSysParamIntValue(SystemParamKeyEnum paramKeyEnum) {
        if (paramKeyEnum == null) {
            return null;
        }
        SysParam sysParam = sysParamMapper.selectByParamKey(paramKeyEnum.getCode());
        if (sysParam == null) {
            return Integer.parseInt(paramKeyEnum.getDefaultValue());
        } else {
            try {
                return Integer.parseInt(sysParam.getParamValue());
            } catch (NumberFormatException e) {
                return Integer.parseInt(paramKeyEnum.getDefaultValue());
            }
        }
    }
}
