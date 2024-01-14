package com.rone.utils.format;

import cn.hutool.core.util.StrUtil;

/**
 * 格式校验工具类
 *
 * @author rone
 **/
public class CheckFormatUtil {

    private CheckFormatUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 手机号码正则表达式
     **/
    public static final String PATTERN_MOBILE = "^1[3|4|5|6|7|8|9][0-9]{9}$";

    /**
     * 手机号码校验
     *
     * @param mobileNo 手机号
     * @return 是否匹配
     */
    public static boolean isMobile(String mobileNo) {
        return (StrUtil.isNotBlank(mobileNo) && mobileNo.matches(PATTERN_MOBILE));
    }
}
