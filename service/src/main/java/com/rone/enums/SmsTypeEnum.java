package com.rone.enums;

/**
 * 手机短信，发送的类型
 *
 * @author rone
 */
public enum SmsTypeEnum {
    OTHER("0", "其他"),
    AUTH_CODE("1", "验证码");

    private final String code;

    private final String name;

    SmsTypeEnum(String code, String name) {
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
