package com.rone.jobs;

import com.rone.entity.RightsActivity;
import com.rone.service.RightsActivityService;
import com.rone.service.impl.RightsActivityServiceImpl;
import com.rone.utils.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时去清理 权益活动的本机缓存
 *
 * @author rone
 */
@Component
public class ClearRightsActivityReceiveTimesMapJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClearRightsActivityReceiveTimesMapJob.class);

    @Autowired
    private RightsActivityService rightsActivityService;

    /**
     * 每天 0:00 跑任务
     */
    @Scheduled(cron = "0 0 0 * * ? ")
    private void cleanRightsActivityReceiveTimesMap() {
        LOGGER.info("********** 权益活动，清理本机的领劵人数缓存 - 开始 **********");
        List<RightsActivity> rightsActivityList = rightsActivityService.getInUse();
        List<Integer> rightsActivityIdList = new ArrayList<>();
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        for (RightsActivity rightsActivity : rightsActivityList) {
            if ((rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0)
                    || (rightsActivity.getPhaseRightsTotalNum() != null && rightsActivity.getPhaseRightsTotalNum() > 0)) {
                if (checkStartDate(rightsActivity.getStartDate(), now)
                        && checkEndDate(rightsActivity.getEndDate(), now)
                        && checkReceiveCycle(rightsActivity.getReceiveCycle(), week)) {
                    rightsActivityIdList.add(rightsActivity.getId());
                }
            }
        }
        LOGGER.info("********** 权益活动，清理本机的领劵人数缓存 - 今天需要抢劵的活动数量:{} **********", rightsActivityIdList.size());
        synchronized (RightsActivityServiceImpl.class) {
            RightsActivityServiceImpl.receiveTimesMap = new HashMap<>();
            for (Integer id : rightsActivityIdList) {
                RightsActivityServiceImpl.receiveTimesMap.put(id, new AtomicInteger());
            }
        }
        LOGGER.info("********** 权益活动，清理本机的领劵人数缓存 - 结束 **********");
    }

    /**
     * 校验是否在活动开始时间之后
     *
     * @param startDateStr
     * @param now
     * @return
     */
    private boolean checkStartDate(String startDateStr, Date now) {
        if (StringUtils.isNotEmpty(startDateStr)) {
            Date startDate = DateUtil.strToDate(startDateStr, "yyyy-MM-dd");
            return now.getTime() >= startDate.getTime();
        }
        return true;
    }

    /**
     * 校验是否在活动截止时间之前
     *
     * @param endDateStr
     * @param now
     * @return
     */
    private boolean checkEndDate(String endDateStr, Date now) {
        if (StringUtils.isNotEmpty(endDateStr)) {
            Date endDate = DateUtil.strToDate(endDateStr, "yyyy-MM-dd");
            endDate = DateUtil.changeDayOfMonth(endDate, 1);
            return now.getTime() <= endDate.getTime();
        }
        return true;
    }

    /**
     * 校验当前日期是否在领取周期内
     *
     * @param receiveCycle
     * @param week
     * @return
     */
    private boolean checkReceiveCycle(String receiveCycle, int week) {
        if (StringUtils.isNotEmpty(receiveCycle)) {
            return receiveCycle.indexOf(String.valueOf(week)) != -1;
        }
        return true;
    }
}
