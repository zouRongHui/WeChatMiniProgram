package com.rone.enums.user;

/**
 * 用户状态枚举
 *
 * @author rone
 */
public enum UserInfoStatusEnum {
    NORMAL("00", "正常"),
    TEMP_LOCK("01", "临时锁定"),
    LOCK("02", "永久锁定"),
    UNREGISTER("03", "注销");

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

    public static UserInfoStatusEnum getByCode(String code) {
        for (UserInfoStatusEnum statusEnum : UserInfoStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }

        return null;
    }
}
