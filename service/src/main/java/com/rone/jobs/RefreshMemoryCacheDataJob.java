package com.rone.jobs;

import com.rone.constant.WeChatMemoryCacheData;
import com.rone.dao.BlockUserMapper;
import com.rone.entity.BlockUser;
import com.rone.entity.BlockUserCriteria;
import com.rone.enumeration.YesOrNoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 更新内存中的缓存数据
 *
 * @author rone
 */
@Component
public class RefreshMemoryCacheDataJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshMemoryCacheDataJob.class);
    @Resource
    private BlockUserMapper blockUserMapper;

    @Scheduled(cron = "0 3/10 * * * ? ")
    private void execute1() {
        refreshBlockUser();
        System.gc();
    }

    /**
     * 更新黑名单用户数据
     */
    private void refreshBlockUser() {
        BlockUserCriteria blockUserCriteria = new BlockUserCriteria();
        blockUserCriteria.createCriteria().andStatusEqualTo(String.valueOf(YesOrNoEnum.YES.getCode()));
        List<BlockUser> blockUserList = blockUserMapper.selectByExample(blockUserCriteria);
        Set<String> phoneSet = new HashSet<>();
        Set<String> openIdSet = new HashSet<>();
        for (BlockUser blockUser : blockUserList) {
            phoneSet.add(blockUser.getPhone());
            openIdSet.add(blockUser.getOpenId());
        }
        WeChatMemoryCacheData.BLOCK_USER_CACHE_DATA.setPhoneSet(phoneSet);
        WeChatMemoryCacheData.BLOCK_USER_CACHE_DATA.setOpenIdSet(openIdSet);
        LOGGER.info("********** 更新内存中的缓存数据，黑名单用户 - 成功更新了 {}条手机、{}条openId数据 **********", phoneSet.size(), openIdSet.size());
    }
}
