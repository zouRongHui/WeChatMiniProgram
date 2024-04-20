package com.rone.service;

import com.github.pagehelper.PageInfo;
import com.rone.entity.BlockUser;
import com.rone.qo.BlockUserQO;
import com.rone.vo.BlockUserVO;

/**
 * 黑名单
 *
 * @author rone
 */
public interface BlockUserService {

    /**
     * 分页查询
     *
     * @param qo
     * @return
     * @author rone
     */
    PageInfo<BlockUserVO> getPageList(BlockUserQO qo);

    /**
     * 新增黑名单用户
     *
     * @param blockUser
     * @return
     */
    int add(BlockUser blockUser);

    /**
     * 删除
     *
     * @param ids
     * @return
     * @author rone
     */
    int delete(Long... ids);

    /**
     * 启用
     *
     * @param id
     * @return
     * @author rone
     */
    int usable(Long id);

    /**
     * 停用
     *
     * @param id
     * @return
     * @author rone
     */
    int disable(Long id);
}
