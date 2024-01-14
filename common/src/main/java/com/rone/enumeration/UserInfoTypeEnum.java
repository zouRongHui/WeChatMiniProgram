package com.rone.enumeration;

/**
 * 用户类别
 *
 * @author rone
 */
public enum UserInfoTypeEnum {
    SS_VIP(1, "超级VIP"),
    S_VIP(2, "高级VIP"),
    VIP(3, "一般VIP");

    private final Integer code;
    private final String name;

    UserInfoTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
