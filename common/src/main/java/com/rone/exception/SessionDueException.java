package com.rone.exception;

/**
 * session过期异常
 *
 * @author rone
 */
public class SessionDueException extends RoneException {
    public SessionDueException() {
    }

    public SessionDueException(String message) {
        super(message);
    }

    public SessionDueException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionDueException(Throwable cause) {
        super(cause);
    }

    public SessionDueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
