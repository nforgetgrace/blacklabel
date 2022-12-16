package com.gooks.blacklabel.common.exception;

import com.gooks.blacklabel.common.exception.messege.ErrorCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class MovieResultException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;
    private final List<String> detail;

    public MovieResultException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detail = null;
    }

    public MovieResultException(ErrorCode errorCode, String detail) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detail = Arrays.asList(detail);
    }

}
