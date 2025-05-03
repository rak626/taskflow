package com.rakesh.taskflow.exception;

public class AuthorizationException extends Throwable {
    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
