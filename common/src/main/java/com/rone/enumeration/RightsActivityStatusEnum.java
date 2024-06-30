package com.rone.enumeration;

/**
 * 权益活动的状态
 *
 * @author rone
 */
public enum RightsActivityStatusEnum {
    DISABLE("0", "停用"),
    USABLE("1", "启用");

    private final String code;

    private final String name;

    RightsActivityStatusEnum(String code, String name) {
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
