package com.rone.enumeration;

/**
 * 管理平台用户登陆日志，状态值枚举
 *
 * @author rone
 */
public enum AdminLoginLogStatusEnum {
    SUCCESS("0", "登陆成功"),
    NO_ACCOUNT("1", "登陆失败，账号不存在"),
    PASS_FAIL("1", "登陆失败，密码错误");

    private final String code;
    private final String name;

    AdminLoginLogStatusEnum(String code, String name) {
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
