package com.rone.vo;

import com.rone.enumeration.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回体
 *
 * @author rone
 */
@ApiModel
public class Result<T> {

    @ApiModelProperty("状态值，0：成功；1：出错；-1：登陆过期")
    private Integer code;

    @ApiModelProperty("当状态值为1时，在此说明错误的具体信息")
    private String message;

    @ApiModelProperty("当状态值为0时，该属性返回具体数据")
    private T data;

    public static Result sessionDue() {
        return new Result(ResultCodeEnum.SESSION_DUE.getCode(), "登陆过期，请重新登陆", null);
    }

    public static Result success() {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), "", null);
    }

    public static Result success(String message) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), message, null);
    }

    public static <T> Result success(String message, T data) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result success(T data) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), "", data);
    }

    public static Result fault(String message) {
        return new Result(ResultCodeEnum.FAIL.getCode(), message, null);
    }

    public static <T> Result fault(String message, T data) {
        return new Result(ResultCodeEnum.FAIL.getCode(), message, data);
    }

    public static Result noData(int code, String message) {
        return new Result(code, message, null);
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
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

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
