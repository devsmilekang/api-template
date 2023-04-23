package com.kms.api.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {


    INVALID_PARAMETER("9001", "파라메터가 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    HTTP_MESSAGE_CONVERSION("9002", "메세지 변환에 실패하였습니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("9999", "시스템 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR)
    ;

    private String code;
    private String msg;
    private HttpStatus httpStatus;

    ErrorCode(String code, String msg, HttpStatus httpStatus) {
        this.code = code;
        this.msg = msg;
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
