package com.rone.exception;

/**
 * 与第三方平台交互异常
 *
 * @author rone
 */
public class ThirdPlatformException extends RoneException {
    public ThirdPlatformException() {
    }

    public ThirdPlatformException(String message) {
        super(message);
    }

    public ThirdPlatformException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThirdPlatformException(Throwable cause) {
        super(cause);
    }

    public ThirdPlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
