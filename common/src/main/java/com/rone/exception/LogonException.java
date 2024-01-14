package com.rone.exception;

/**
 * 登陆异常
 *
 * @author rone
 */
public class LogonException extends RoneException {
    public LogonException() {
    }

    public LogonException(String message) {
        super(message);
    }

    public LogonException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogonException(Throwable cause) {
        super(cause);
    }

    public LogonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
