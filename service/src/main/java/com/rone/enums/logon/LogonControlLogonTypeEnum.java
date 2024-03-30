package com.rone.enums.logon;

/**
 * 登陆时认证的方式
 *
 * @author rone
 */
public enum LogonControlLogonTypeEnum {
    SMS_AUTH_CODE("1", "手机验证码"),
    FINGERPRINT("2", "指纹");

    private final String code;

    private final String name;

    LogonControlLogonTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
