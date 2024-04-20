package com.rone.enumeration;

/**
 * 返回状态码
 *
 * @author rone
 */
public enum ResultCodeEnum {
    SUCCESS(0, "操作成功"),
    FAIL(1, "操作失败，详细原因见错误说明"),
    SESSION_DUE(-1, "登陆凭证过期"),
    PARAM_ERROR(10001, "参数出错，请检查参数后重新操作"),
    TIMESTAMP_ERROR(10002, "时间戳校验出错");

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
