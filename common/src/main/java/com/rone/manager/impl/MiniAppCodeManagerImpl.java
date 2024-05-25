package com.rone.manager.impl;

import com.rone.dao.MiniAppCodeMapper;
import com.rone.entity.MiniAppCode;
import com.rone.entity.MiniAppCodeCriteria;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.exception.ThirdPlatformException;
import com.rone.exception.RoneException;
import com.rone.manager.MiniAppCodeManager;
import com.rone.service.SysParamService;
import com.rone.api.wechat.WeChatApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

/**
 * 小程序码 通用逻辑层
 *
 * @author rone
 */
@Service
@Transactional
public class MiniAppCodeManagerImpl implements MiniAppCodeManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(MiniAppCodeManagerImpl.class);

    @Resource
    private MiniAppCodeMapper mapper;
    @Autowired
    private WeChatApi weChatApi;
    @Autowired
    private SysParamService sysParamService;

    @Override
    public MiniAppCode getByPagePath(String pagePath, String pageParam) throws IOException, URISyntaxException, RoneException {
        if (StringUtils.isEmpty(pagePath)) {
            return new MiniAppCode();
        }

        // 相同参数的的小程序码，直接返回之前生成的数据
        MiniAppCodeCriteria miniAppCodeCriteria = new MiniAppCodeCriteria();
        miniAppCodeCriteria.createCriteria().andCodeParamsEqualTo(pagePath + "?" + pageParam);
        List<MiniAppCode> miniAppCodeList = mapper.selectByExample(miniAppCodeCriteria);
        if (miniAppCodeList != null && !miniAppCodeList.isEmpty() && miniAppCodeList.get(0) != null) {
            return miniAppCodeList.get(0);
        }

        // accessToken有定时任务去更新该参数，如果使用的时候发现已过期，支持手动去更新
        String accessToken = sysParamService.getSysParamValue(SystemParamKeyEnum.WECHAT_ACCESS_TOKEN.getCode());
        byte[] codeBytes;
        try {
            codeBytes = weChatApi.getMiniAppCodeUnlimited(accessToken, pageParam, pagePath);
        } catch (ThirdPlatformException e) {
            try {
                LOGGER.info("获取小程序码异常，可能原因是AccessToken过期未及时更新，现在开始手动更新微信小程序AccessToken，开始");
                accessToken = weChatApi.getAccessToken();
                int updateCount = sysParamService.updateSysParamValueByKey(SystemParamKeyEnum.WECHAT_ACCESS_TOKEN.getCode(), accessToken);
                if (updateCount < 1) {
                    LOGGER.error("获取小程序码出错，手动更新微信小程序AccessToken出错，出错信息：更新数据量小于1个，请检查系统参数的设定是否正常");
                    throw new ThirdPlatformException("获取小程序码出错，手动更新微信小程序AccessToken，出错，出错信息：更新数据量小于1个，请检查系统参数的设定是否正常");
                }
            } catch (Exception e1) {
                LOGGER.error(e1.getMessage(), e1);
                throw new ThirdPlatformException("获取小程序码出错，手动更新微信小程序AccessToken出错");
            }
            codeBytes = weChatApi.getMiniAppCodeUnlimited(accessToken, pageParam, pagePath);
        }
        String codeUrl = new String(codeBytes);
        MiniAppCode miniAppCode = new MiniAppCode();
        miniAppCode.setCodeParams(pagePath + "?" + pageParam);
        miniAppCode.setCodeUrl(codeUrl);
        miniAppCode.setGenerateTime(new Date());
        mapper.insert(miniAppCode);
        return miniAppCode;
    }
}
