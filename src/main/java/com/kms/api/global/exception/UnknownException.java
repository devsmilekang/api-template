package com.kms.api.global.exception;

import org.springframework.http.HttpStatus;

public class UnknownException extends BaseException{
    public UnknownException(String message) {
        super(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), message, ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus());
    }
}
