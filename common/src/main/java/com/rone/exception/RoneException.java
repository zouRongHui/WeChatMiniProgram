package com.rone.exception;

/**
 * 异常
 *
 * @author rone
 */
public class RoneException extends Exception {
    public RoneException() {
    }

    public RoneException(String message) {
        super(message);
    }

    public RoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoneException(Throwable cause) {
        super(cause);
    }

    public RoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
