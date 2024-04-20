package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.BlockUserMapper;
import com.rone.entity.BlockUser;
import com.rone.entity.BlockUserCriteria;
import com.rone.enumeration.YesOrNoEnum;
import com.rone.qo.BlockUserQO;
import com.rone.service.BlockUserService;
import com.rone.utils.date.DateUtil;
import com.rone.vo.BlockUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 黑名单
 *
 * @author rone
 */
@Component
@Transactional
public class BlockUserServiceImpl implements BlockUserService {

    @Resource
    private BlockUserMapper mapper;

    @Override
    public PageInfo<BlockUserVO> getPageList(BlockUserQO qo) {
        BlockUserCriteria blockUserCriteria = new BlockUserCriteria();
        BlockUserCriteria.Criteria criteria = blockUserCriteria.createCriteria();
        if (StringUtils.isNotEmpty(qo.getCreateTimeStart())) {
            System.out.println(DateUtil.strToDate(qo.getCreateTimeStart(), "yyyy-MM-dd"));
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.strToDate(qo.getCreateTimeStart(), "yyyy-MM-dd"));
        }
        if (StringUtils.isNotEmpty(qo.getCreateTimeEnd())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.strToDate(qo.getCreateTimeEnd() + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
        }
        blockUserCriteria.setOrderByClause(" CREATE_TIME desc");
        if (qo.getPage() == null) {
            qo.setPage(1);
        }
        if (qo.getSize() == null) {
            qo.setSize(10);
        }
        if (qo.getSize() > 0) {
            PageHelper.startPage(qo.getPage(), qo.getSize());
        }
        List<BlockUser> blockUserList = mapper.selectByExample(blockUserCriteria);
        PageInfo pageInfo = new PageInfo<>(blockUserList);

        List<BlockUserVO> voList = new ArrayList<>(blockUserList.size());
        for (BlockUser blockUser : blockUserList) {
            BlockUserVO vo = new BlockUserVO(blockUser);
            voList.add(vo);
        }
        pageInfo.setList(voList);
        return pageInfo;
    }

    @Override
    public int add(BlockUser blockUser) {
        blockUser.setCreateTime(new Date());
        blockUser.setEditTime(new Date());
        blockUser.setStatus(String.valueOf(YesOrNoEnum.YES.getCode()));
        return mapper.insert(blockUser);
    }

    @Override
    public int delete(Long... ids) {
        if (ids != null) {
            int count = 0;
            for (Long id : ids) {
                count += mapper.deleteByPrimaryKey(id);
            }
            return count;
        }
        return 0;
    }

    @Override
    public int usable(Long id) {
        BlockUser blockUser = mapper.selectByPrimaryKey(id);
        if (blockUser != null) {
            blockUser.setStatus(String.valueOf(YesOrNoEnum.YES.getCode()));
            blockUser.setEditTime(new Date());
            return mapper.updateByPrimaryKey(blockUser);
        }
        return 0;
    }

    @Override
    public int disable(Long id) {
        BlockUser blockUser = mapper.selectByPrimaryKey(id);
        if (blockUser != null) {
            blockUser.setStatus(String.valueOf(YesOrNoEnum.NO.getCode()));
            blockUser.setEditTime(new Date());
            return mapper.updateByPrimaryKey(blockUser);
        }
        return 0;
    }
}
