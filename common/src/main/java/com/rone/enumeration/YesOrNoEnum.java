package com.rone.enumeration;

/**
 * 是否含义的枚举，统一是否的编码定义
 *
 * @author rone
 */
public enum YesOrNoEnum {
    NO(0, "否"),
    YES(1, "是");

    private final Integer code;

    private final String name;

    YesOrNoEnum(Integer code, String name) {
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
