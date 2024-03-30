package com.rone.constant;

/**
 * HttpSession常量
 *
 * @author rone
 */
public class HttpSessionAttributeConstant {

    /**
     * 用户信息，value类型
     *
     * @see com.rone.model.LogonUserInfo
     */
    public static final String LOGON_USER_INFO = "logonUserInfo";

    /**
     * 微信小程序openId，value类型为 String
     */
    public static final String OPEN_ID = "openId";

    /**
     * 微信小程序session_key，value类型为 String
     */
    public static final String SESSION_KEY = "sessionKey";

    /**
     * 微信小程序unionId，value类型为 String
     */
    public static final String UNION_ID = "unionId";

    /**
     * 短信验证码，value类型
     *
     * @see com.rone.model.SmsAuthCode
     */
    public static final String SMS_AUTH_CODE = "smsAuthCode";
}
