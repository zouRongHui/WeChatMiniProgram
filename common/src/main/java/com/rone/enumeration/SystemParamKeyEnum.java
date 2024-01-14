package com.rone.enumeration;

/**
 * 系统参数key值枚举
 *
 * @author rone
 */
public enum SystemParamKeyEnum {
    INDEX_SWIPER_INTERVAL("wd_index_swiper_interval", "小程序首页轮播图的自动切换间隔时间", ""),
    ASTRICT_IP_SEND_SMS_MINUTES("wd_astrict_ip_send_sms_minutes", "限制同一IP发送手机短信的时长", "5"),
    ASTRICT_IP_SEND_SMS_TIMES("wd_astrict_ip_send_sms_times", "限制同一IP发送手机短信的次数", "10"),
    ASTRICT_PHONE_NUMBER_SEND_SMS_MINUTES("wd_astrict_phone_send_sms_minutes", "限制同一手机号发送手机短信的时长", "1"),
    ASTRICT_PHONE_NUMBER_SEND_SMS_TIMES("wd_astrict_phone_send_sms_times", "限制同一手机号发送手机短信的次数", "3"),
    LAUNCH_PAGE_PICTURE("wd_launch_page_picture", "启动页图片路径", ""),
    LAUNCH_PAGE_REDIRECT("wd_launch_page_redirect", "小程序启动页点击转跳路径", ""),
    INDEX_NAVIGATION_DISTANCE("wd_index_navigation_distance", "小程序首页轮播图导航栏间距", ""),
    LAUNCH_PAGE_DURATION("wd_launch_page_duration", "小程序启动页持续时长", ""),
    WECHAT_ACCESS_TOKEN("wd_wechat_access_token", "微信小程序的access_token", ""),
    ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES("admin_login_fail_times_limit_minutes", "管理平台用户登陆失败超次的时长", "10"),
    ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES("admin_login_fail_times_limit_times", "管理平台用户登陆失败超次的次数", "3"),
    ADMIN_LOGIN_FAIL_TIMES_DISABLE_TIME("admin_login_fail_times_disable_time", "管理平台用户登录失败超次后多少时间禁止登陆", "1"),
    ASTRICT_LOGON_TIMES_PER_MINUTE("wd_astrict_logon_times_per_minute", "限制登录频率，1分钟内最多请求XX次", "20"),
    BLOCK_USER_RULE_ONE_URL_TIMES("wd_block_user_rule_one_url_times", "黑名单用户规则，单一接口请求上限/分钟", "800"),
    BLOCK_USER_RULE_ALL_URL_TIMES("wd_block_user_rule_all_url_times", "黑名单用户规则，所有接口的请求上限/分钟", "800"),
    BLOCK_USER_RULE_TIMESTAMP_ERROR_TIMES("wd_block_user_rule_timestamp_error_times", "黑名单用户规则，时间戳不一致的上限/天", "10"),
    BLOCK_USER_RULE_RUN_FLAG("wd_block_user_rule_run_flag", "黑名单用户规则，相关限制程序是否执行，0:不执行,1:执行", "0"),
    HUMAN_VERIFICATION_MINUTES("wd_human_verification_minutes", "人机验证频率，分钟", "10"),
    HUMAN_VERIFICATION_TIMES("wd_human_verification_times", "人机验证频率，次数", "100"),
    HUMAN_VERIFICATION_SHAKE_RANGE("wd_human_verification_shake_range", "人机验证-摇一摇幅度", "1.5"),
    ANNOUNCEMENT("wd_announcement", "首页的滚动公告，若设置为空则不展示！", "");

    private final String code;

    private final String name;
    /**
     * 默认值
     */
    private final String defaultValue;

    SystemParamKeyEnum(String code, String name, String defaultValue) {
        this.code = code;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
