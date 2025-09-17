package com.java360.pmanager.infrastructure.exception;

import lombok.Getter;

// Para criar uma exceção em java é necessário extender
@Getter
public class RequestException extends RuntimeException{

    private final String errorCode;

    public RequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
