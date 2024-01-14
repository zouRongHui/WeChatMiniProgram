package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.RightsActivity;
import com.rone.entity.RightsActivityAllowList;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.qo.RightsActivityQO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 权益活动配置
 *
 * @author rone
 */
public interface RightsActivityService {

    /**
     * 分页查询
     *
     * @param qo
     * @return
     */
    PageInfo<RightsActivity> pageList(RightsActivityQO qo);

    /**
     * 新增
     *
     * @param rightsActivity
     * @return
     */
    int add(RightsActivity rightsActivity);

    /**
     * 根据主键获取
     *
     * @param id
     * @return
     */
    RightsActivity findById(Integer id);

    /**
     * 修改编辑
     *
     * @param rightsActivity
     * @return
     * @throws RoneException
     */
    int edit(RightsActivity rightsActivity) throws RoneException;

    /**
     * 标识为删除
     *
     * @param ids
     * @return
     */
    int delete(Integer... ids);

    /**
     * 启用
     *
     * @param id
     * @return
     * @throws RoneException
     */
    int usable(Integer id) throws RoneException;

    /**
     * 停用
     *
     * @param id
     * @return
     * @throws ParamException
     */
    int disable(Integer id) throws ParamException;

    /**
     * 获取权益活动对应的小程序码
     *
     * @param id
     * @return
     * @throws RoneException
     * @throws IOException
     * @throws URISyntaxException
     */
    String getRightsActivityMiniAppCode(Integer id) throws RoneException, IOException, URISyntaxException;

    /**
     * 白名单-分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @param phone
     * @return
     */
    PageInfo<RightsActivityAllowList> allowListPageList(Integer pageNum, Integer pageSize, Integer id, String phone);

    /**
     * 白名单新增
     *
     * @param rightsActivityAllowList
     * @return
     * @throws RoneException
     */
    int allowListAdd(RightsActivityAllowList rightsActivityAllowList) throws RoneException;

    /**
     * 白名单删除
     *
     * @param phones
     * @param rightsActivityId
     * @return
     * @throws RoneException
     */
    int allowListDelete(String[] phones, Integer rightsActivityId) throws RoneException;

    /**
     * 白名单删除 - 全部删除
     *
     * @param rightsActivityId
     * @return
     * @throws RoneException
     */
    int allowListDeleteAll(Integer rightsActivityId) throws RoneException;

    /**
     * 白名单导入
     *
     * @param file
     * @param rightsActivityId
     * @return
     * @throws ParamException
     * @throws IOException
     */
    int allowListImport(MultipartFile file, Integer rightsActivityId) throws ParamException, IOException;
}
