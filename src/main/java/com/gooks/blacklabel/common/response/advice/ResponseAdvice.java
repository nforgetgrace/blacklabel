package com.gooks.blacklabel.common.response.advice;

import com.gooks.blacklabel.common.aop.custom.annotation.EnableCommonApiResponse;
import com.gooks.blacklabel.common.response.CommonResponseNoUesList;
import com.gooks.blacklabel.common.response.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.apache.commons.lang3.EnumUtils;

/**
* @package : com.gooks.blacklabel.common.response.advice
* @name : ResponseAdvice.java
* @date : 2022-12-15 오전 9:21
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : @RestControllerAdvice를 활용하여 Resp Body를 처리할 수 있다.
* ResponseBodyAdvice를 사용하기 위해서 supports와 beforeBodyWrite을 오버라이딩
* support에서 Controller작업이 끝난 response beforeBodyWrite로 보낼 것인지 판단
* supports로 판단해서 들어온 body를 활용 사용자가 원하는 작업을 수행
**/
@Slf4j
@RestControllerAdvice
@ConditionalOnBean(annotation = EnableCommonApiResponse.class)
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(final MethodParameter returnType, final Class converterType) {
        log.info("[ResponseAdvice] supports method");
        String methodName = returnType.getMethod().getName();

        //공통 응답템플릿을 사용하지않는 경우 ResponseBodyNoneUse에 정의
        if(EnumUtils.isValidEnum(CommonResponseNoUesList.class, methodName ) ) { //사용하지않는 메소드명 일치

            if(CommonResponseNoUesList.valueOf(methodName).getClassName().equals(returnType.getDeclaringClass().getSimpleName())) { //사용하지않는 클래스명 일치
                return false;
            }
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(final Object body, final MethodParameter returnType, final MediaType selectedContentType, final Class selectedConverterType, final ServerHttpRequest request, final ServerHttpResponse response) {
        log.info("[ResponseAdvice] beforeBodyWrite method");
        return new ApiResponse(body);
    }
}
