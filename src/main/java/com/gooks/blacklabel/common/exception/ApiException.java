package com.gooks.blacklabel.common.exception;

import com.gooks.blacklabel.common.exception.messege.ErrorCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 어플리케이션 표준 에러
 */
@Getter
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;
    private final List<String> detail;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detail = null;
    }

    public ApiException(ErrorCode errorCode, String detail) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detail = Arrays.asList(detail);
    }
}