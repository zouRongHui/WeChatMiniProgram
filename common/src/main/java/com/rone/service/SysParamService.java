package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.SysParam;
import com.rone.enumeration.SystemParamKeyEnum;

/**
 * 系统参数管理
 *
 * @author rone
 */
public interface SysParamService {

    /**
     * 分页查询
     *
     * @param page      页码
     * @param size      每页展示条数
     * @param paramKey  参数key
     * @param paramName 参数名称
     * @return
     */
    PageInfo<SysParam> getPageList(Integer page, Integer size, String paramKey, String paramName);

    /**
     * 新增系统参数
     *
     * @param sysParam 系统参数信息
     * @return
     */
    SysParam add(SysParam sysParam);

    /**
     * 编号查询系统参数
     *
     * @param id 系统参数ID
     * @return
     */
    SysParam getById(Integer id);

    /**
     * 更新
     *
     * @param sysParam 系统参数信息
     * @return
     */
    SysParam update(SysParam sysParam);

    /**
     * 停用
     *
     * @param id 系统参数ID
     * @return
     */
    SysParam stop(Integer id);

    /**
     * 启用
     *
     * @param id 系统参数ID
     * @return
     */
    SysParam start(Integer id);

    /**
     * 删除
     *
     * @param ids 系统参数ID
     */
    void delete(Integer... ids);

    /**
     * 根据系统参数key获取参数值
     *
     * @param paramKey
     * @return
     * @author rone
     */
    String getSysParamValue(String paramKey);

    /**
     * 根据系统参数key修改参数value
     *
     * @param paramKey
     * @param paramValue
     * @return
     * @author rone
     */
    int updateSysParamValueByKey(String paramKey, String paramValue);

    /**
     * 根据系统参数枚举来获取数值，若不存在则返回默认值
     *
     * @param paramKeyEnum
     * @return
     */
    String getSysParamValue(SystemParamKeyEnum paramKeyEnum);

    /**
     * 根据系统参数枚举来获取int值，若不存在则返回默认值
     *
     * @param paramKeyEnum
     * @return
     */
    Integer getSysParamIntValue(SystemParamKeyEnum paramKeyEnum);
}
