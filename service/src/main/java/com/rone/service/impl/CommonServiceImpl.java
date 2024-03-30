package com.rone.service.impl;

import com.rone.api.wechat.WeChatApi;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.exception.RoneException;
import com.rone.exception.WeChatAccessTokenExpireException;
import com.rone.model.WeChatUserEncryptKeyResult;
import com.rone.service.CommonService;
import com.rone.service.SysParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 共用的服务
 *
 * @author rone
 */
@Component
@Transactional
public class CommonServiceImpl implements CommonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private SysParamService sysParamService;
    @Autowired
    private WeChatApi weChatApi;

    @Override
    public Map<Integer, String> getWeChatUserEncryptKey(String openid, String sessionKey) throws RoneException {
        String accessToken = sysParamService.getSysParamValue(SystemParamKeyEnum.WECHAT_ACCESS_TOKEN.getCode());
        try {
            WeChatUserEncryptKeyResult weChatUserEncryptKeyResult = weChatApi.getUserEncryptKey(accessToken, openid, sessionKey);
            Map<Integer, String> weChatUserEncryptKeyMap = new HashMap<>(3);
            for (WeChatUserEncryptKeyResult.KeyInfo keyInfo : weChatUserEncryptKeyResult.getKey_info_list()) {
                weChatUserEncryptKeyMap.put(keyInfo.getVersion(), keyInfo.getEncrypt_key());
            }
            return weChatUserEncryptKeyMap;
        } catch (WeChatAccessTokenExpireException e) {
            throw new RoneException("网络请求繁忙，请稍后再试");
        } catch (RoneException e) {
            return new HashMap<>(3);
        }
    }
}
