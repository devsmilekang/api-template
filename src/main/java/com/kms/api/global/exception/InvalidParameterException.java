package com.kms.api.global.exception;

public class InvalidParameterException extends BaseException{

    public InvalidParameterException(String msg) {
        super(ErrorCode.INVALID_PARAMETER.getCode(), ErrorCode.INVALID_PARAMETER.getMsg(), ErrorCode.INVALID_PARAMETER.getHttpStatus());
    }
}
