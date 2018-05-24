package org.rone.study.springBoot.model;

/**
 * Created by rone on 2018/4/26.
 */
public class Result<T> {

    /**
     * 状态值，0：成功；1：出错。
     */
    private Integer code = 0;

    /**
     * 当状态值为1时，在此说明错误的具体信息
     */
    private String message;

    private T data;

    public static Result success() {
        return new Result(0, "", null);
    }

    public static Result success(String message) {
        return new Result(0, message, null);
    }

    public static <T> Result success(String message, T data) {
        return new Result(0, message, data);
    }

    public static <T> Result success(T data) {
        return new Result(0,"",data);
    }

    public static Result fault(String message) {
        return new Result(1, message, null);
    }

    public static <T> Result fault(String message, T data) {
        return new Result(1, message, data);
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
