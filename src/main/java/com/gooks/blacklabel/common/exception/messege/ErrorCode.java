package com.gooks.blacklabel.common.exception.messege;

import org.springframework.http.HttpStatus;

/**
* @package : com.gooks.blacklabel.common.exception.messege
* @name : ErrorCode.java
* @date : 2022-12-14 오후 4:16
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 에러코드 인터페이스
**/

public interface ErrorCode {
    String getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
