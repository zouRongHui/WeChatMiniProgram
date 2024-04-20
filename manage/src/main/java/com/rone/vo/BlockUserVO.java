package com.rone.vo;

import com.rone.entity.BlockUser;

/**
 * 黑名单
 *
 * @author rone
 */
public class BlockUserVO extends BlockUser {

    public BlockUserVO() {
        super();
    }

    public BlockUserVO(BlockUser blockUser) {
        super();
        this.setId(blockUser.getId());
        this.setPhone(blockUser.getPhone());
        this.setOpenId(blockUser.getOpenId());
        this.setRule(blockUser.getRule());
        this.setCreateTime(blockUser.getCreateTime());
        this.setStatus(blockUser.getStatus());
        this.setEditTime(blockUser.getEditTime());
    }
}
