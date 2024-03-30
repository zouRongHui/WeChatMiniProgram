package com.rone.exception;

/**
 * 请求微信接口是上送的AccessToken过期
 *
 * @author rone
 */
public class WeChatAccessTokenExpireException extends RoneException {
    public WeChatAccessTokenExpireException() {
    }

    public WeChatAccessTokenExpireException(String message) {
        super(message);
    }

    public WeChatAccessTokenExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatAccessTokenExpireException(Throwable cause) {
        super(cause);
    }

    public WeChatAccessTokenExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
