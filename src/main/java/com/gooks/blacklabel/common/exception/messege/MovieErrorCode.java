package com.gooks.blacklabel.common.exception.messege;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
* @package : com.gooks.blacklabel.common.exception.messege
* @name : MovieErrorCode.java
* @date : 2022-12-16 오전 9:31
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : ErrorCode인터페이스를 받았으니 @Getter를 사용해야함.
**/

@Getter
@AllArgsConstructor
public enum MovieErrorCode implements ErrorCode{

    MOVIE_SEARCH_COMMON("AIRPAY_COMMON","죄송합니다. 결제처리중 오류 발생하였습니다.\n" +
            "자세한 문의는 [온라인 문의]를 통해 접수 바랍니다.\n" +
            "고객 상담 문의 처리 시간 : 평일기준 09:00~17:00 / 주말, 공휴일 제외");

    String code;
    String message;
    HttpStatus httpStatus;

    MovieErrorCode(String code, String message) {
        this(code, message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
