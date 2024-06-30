package com.rone.service;

import com.rone.entity.RightsActivity;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.qo.ReceiveRightsQO;
import com.rone.qo.RightsActivityFindByIdQO;
import com.rone.vo.RightsActivityVO;

import java.util.List;

/**
 * 权益活动
 *
 * @author rone
 */
public interface RightsActivityService {

    /**
     * 获取所有使用中的数据(未删除、已启用)
     *
     * @return
     */
    List<RightsActivity> getInUse();

    /**
     * 根据主键获取权益活动信息
     *
     * @param qo
     * @return
     */
    RightsActivityVO findVOById(RightsActivityFindByIdQO qo) throws ParamException;

    /**
     * 领取权益
     *
     * @param qo
     * @throws RoneException
     */
    void receiveRights(ReceiveRightsQO qo) throws RoneException;
}
