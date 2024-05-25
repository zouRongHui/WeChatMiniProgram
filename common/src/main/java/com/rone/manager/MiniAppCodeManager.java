package com.rone.manager;

import com.rone.entity.MiniAppCode;
import com.rone.exception.RoneException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 小程序码 通用逻辑层
 *
 * @author rone
 */
public interface MiniAppCodeManager {

    /**
     * 根据页面和参数获取小程序码
     *
     * @param pagePath
     * @param pageParam
     * @return
     * @throws IOException
     * @throws URISyntaxException
     * @throws RoneException
     */
    MiniAppCode getByPagePath(String pagePath, String pageParam) throws IOException, URISyntaxException, RoneException;
}
