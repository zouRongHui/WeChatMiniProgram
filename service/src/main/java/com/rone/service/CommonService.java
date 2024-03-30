package com.rone.service;

import com.rone.exception.RoneException;

import java.util.Map;

/**
 * 共用的服务
 *
 * @author rone
 */
public interface CommonService {

    /**
     * 获取微信密钥
     *
     * @param openid
     * @param sessionKey
     * @return
     * @throws RoneException
     */
    Map<Integer, String> getWeChatUserEncryptKey(String openid, String sessionKey) throws RoneException;
}
