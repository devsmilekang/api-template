package com.kms.api.global.handler;

import com.kms.api.global.exception.BaseException;
import com.kms.api.global.exception.ErrorCode;
import com.kms.api.global.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class HttpExceptionHandler {

    private final MessageSource validatorMessageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception) {
        log.error("handleException", exception);
        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), httpServletRequest.getRequestURI(), ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse validatorException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BindException exception) {
        BindingResult result = exception.getBindingResult();

        String errors = result.getFieldErrors().stream()
                .map(m -> {
                    final String DEFAULT_MESSAGE = " / 파라메터 : " + m.getField() + " / 입력값 : '" + m.getRejectedValue() + "'";
                    for (String code : Objects.requireNonNull(m.getCodes())) {
                        try {
                            return validatorMessageSource.getMessage(code, null, Locale.getDefault()) + DEFAULT_MESSAGE;
                        } catch (NoSuchMessageException noSuchMessageException) {
                        }
                    }
                    return m.getDefaultMessage() + DEFAULT_MESSAGE;
                })
                .collect(Collectors.joining());

        return new ErrorResponse(ErrorCode.INVALID_PARAMETER.getCode(), httpServletRequest.getRequestURI(), errors);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ErrorResponse httpMessageConversionException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpMessageConversionException exception) {
        return new ErrorResponse(ErrorCode.HTTP_MESSAGE_CONVERSION.getCode(), httpServletRequest.getRequestURI(), ErrorCode.HTTP_MESSAGE_CONVERSION.getMsg());
    }

    @ExceptionHandler(BaseException.class)
    public ErrorResponse baseException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseException exception) {
        log.error("baseException", exception);
        httpServletResponse.setStatus(exception.getHttpStatus().value());
        return new ErrorResponse(exception.getCode(), httpServletRequest.getRequestURI(), exception.getMessage());
    }

}
