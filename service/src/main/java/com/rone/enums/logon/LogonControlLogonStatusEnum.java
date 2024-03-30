package com.rone.enums.logon;

/**
 * 登陆状态
 *
 * @author rone
 */
public enum LogonControlLogonStatusEnum {
    SUCCESS("0", "成功"),
    FAIL("2", "失败");

    private final String code;

    private final String name;

    LogonControlLogonStatusEnum(String code, String name) {
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
