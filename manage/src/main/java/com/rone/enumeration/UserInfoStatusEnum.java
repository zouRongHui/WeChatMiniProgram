package com.rone.enumeration;

/**
 * 管理平台用户状态枚举
 *
 * @author rone
 */
public enum UserInfoStatusEnum {
    NORMAL("0", "正常"),
    TEMP_LOCK("1", "临时锁定");

    private final String code;
    private final String name;

    UserInfoStatusEnum(String code, String name) {
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
