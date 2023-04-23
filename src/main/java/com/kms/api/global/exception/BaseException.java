package com.kms.api.global.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends NestedRuntimeException {
    private String code;
    private String msg;
    private HttpStatus httpStatus;

    public BaseException(String code, String msg, HttpStatus httpStatus) {
        super(msg);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
