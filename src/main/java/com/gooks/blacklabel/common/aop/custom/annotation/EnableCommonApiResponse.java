package com.gooks.blacklabel.common.aop.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @package : com.gooks.blacklabel.common.aop.custom.annotation
* @name : EnableCommonApiResponse.java
* @date : 2022-12-15 오후 1:46
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 공통 응답 사용 설정용 SpringBootApplication 에 설정하면 동작
* @see CommonApiResponse
* @see CommonResponseBodyAdvice
**/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCommonApiResponse {
}