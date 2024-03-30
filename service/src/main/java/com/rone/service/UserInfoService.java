package com.rone.service;

import com.rone.exception.RoneException;
import com.rone.qo.CommonQO;
import com.rone.vo.UserInfoTokenVO;
import com.rone.vo.UserInfoVO;

/**
 * 用户信息
 *
 * @author rone
 */
public interface UserInfoService {

    /**
     * 获取用户信息
     *
     * @param qo
     * @return
     * @throws Exception
     */
    UserInfoVO userInfo(CommonQO qo) throws Exception;

    /**
     * 获取用户Token令牌
     *
     * @param qo
     * @return
     */
    String userToken(CommonQO qo) throws RoneException;
}
