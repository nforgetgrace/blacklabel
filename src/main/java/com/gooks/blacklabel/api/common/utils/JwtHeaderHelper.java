package com.gooks.blacklabel.api.common.utils;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
/**
* @package : com.gooks.blacklabel.api.common.utils
* @name : JwtHeaderHelper.java
* @date : 2022-12-19 오후 3:02
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : jwt 토큰을 헤더에 셋팅해준다.
**/
@RequiredArgsConstructor
@Service
public class JwtHeaderHelper {
    /**
    * @package : com.gooks.blacklabel.api.common.utils
    * @name : JwtHeaderHelper.java
    * @date : 2022-12-19 오후 3:02
    * @author : Jung Jae gook
    * @version : 1.0.0
    * @modifyed :
    * @description : aop 로 jwt 토큰을 헤더에 설정 후 HttpHeaders 타입으로 반환한다. ?
    **/
    public HttpHeaders header(HttpHeaders header) {

        if (header == null) {
            header = new HttpHeaders();
        }
        header.setContentType(MediaType.APPLICATION_JSON);

        return header;
    }

    public HttpHeaders header() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return header(httpHeaders);
    }


    /**
     * <pre> JwtTokenHeader.entity </pre>
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 토큰이 설정된 기본 entity 반환
     */
    public HttpEntity<String> entity() {
        return this.entity(null);
    }

    /**
     * <pre> JwtTokenHeader.entityFromHeader </pre>
     * @param HttpHeaders
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 사용자 httpHeaders, 토큰이 설정된 기본 entity 반환
     */
    public HttpEntity<String> entityFromHeader(HttpHeaders httpHeaders) {
        return this.entityFromHeader(null, httpHeaders);
    }

    /**
     * <pre> JwtTokenHeader.entity </pre>
     * @param body
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 body와 토큰이 설정된 기본 entity 반환
     */
    public HttpEntity<String> entity(String body) {
        return this.entity(body, true, null);
    }

    /**
     * <pre> JwtTokenHeader.entityFromHeader </pre>
     * @param body
     * @param HttpHeaders
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 body, 사용자 httpHeaders, 토큰이 설정된 entity 반환
     */
    public HttpEntity<String> entityFromHeader(String body, HttpHeaders httpHeaders) {
        return this.entity(body, true, httpHeaders);
    }

    /**
     * <pre> JwtTokenHeader.entity </pre>
     * @param isToken
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 토큰설정여부에 따라 기본 entity 반환
     */
    public HttpEntity<String> entity(boolean isToken) {
        return this.entity(null, isToken, null);
    }

    /**
     * <pre> JwtTokenHeader.entityFromHeader </pre>
     * @param isToken
     * @param HttpHeaders
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 토큰설정여부, 사용자 httpHeaders를 받아 entity 반환
     */
    public HttpEntity<String> entityFromHeader(boolean isToken, HttpHeaders httpHeaders) {
        return this.entity(null, isToken, httpHeaders);
    }

    /**
     * <pre> JwtTokenHeader.entity </pre>
     * @param body
     * @param isToken
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 body, 토큰설정여부에 따라 기본 entity 반환
     */
    public HttpEntity<String> entity(String body, boolean isToken) {
        return this.entity(body, isToken, null);
    }

    /**
     * <pre> JwtTokenHeader.entity </pre>
     * @param body
     * @param isToken
     * @param HttpHeaders
     * @return HttpEntity<String>
     * @작성자 a02374
     * @작성일 2022. 5. 19.
     * @리턴타입 HttpEntity<String>
     * @설명 토큰설정여부에 따라 body가 설정된 entity 반환
     */
    public HttpEntity<String> entity(String body, boolean isToken, HttpHeaders httpHeaders) {
        if(isToken) {
            httpHeaders = header(httpHeaders);
        } else {
            if(httpHeaders == null) {
                httpHeaders = new HttpHeaders();
            }
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }

        HttpEntity<String> request = null;

        if(body != null) {
            request = new HttpEntity<>(body, httpHeaders);
        } else {
            request = new HttpEntity<>(httpHeaders);
        }

        return request;
    }
}