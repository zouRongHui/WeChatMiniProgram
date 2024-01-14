package com.rone.utils;

/**
 * Ajax请求后需要返回的对象
 *
 * @author rone
 **/
public class JsonResult {

    /**
     * 是否成功
     */
    private boolean success = true;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 其他信息，用于存储要请求的数据
     */
    private Object obj = null;

    /**
     * 参数错误
     */
    public static JsonResult ERROR_PARAM = failure("[ERROR PARAM]");

    /**
     * 失败，返回提示信息
     *
     * @param message 提示信息
     * @return
     */
    public static JsonResult failure(String message) {
        return new JsonResult(false, message, null);
    }

    /**
     * 成功，返回其他信息
     *
     * @param obj 其他信息
     * @return
     */
    public static JsonResult success(Object obj) {
        return new JsonResult(true, null, obj);
    }

    /**
     * 成功，返回提示信息和其他信息
     *
     * @param message 提示信息
     * @param obj     其他信息
     * @return
     */
    public static JsonResult success(String message, Object obj) {
        return new JsonResult(true, message, obj);
    }

    /**
     * 成功返回提示信息
     *
     * @param message
     * @return
     */
    public static JsonResult success(String message) {
        return new JsonResult(true, message, null);
    }

    /**
     * 成功，没有提示信息和其他信息
     *
     * @return
     */
    public static JsonResult succeed() {
        return success(null);
    }

    public JsonResult() {
        super();
    }

    public JsonResult(boolean success, String msg, Object obj) {
        super();
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}

