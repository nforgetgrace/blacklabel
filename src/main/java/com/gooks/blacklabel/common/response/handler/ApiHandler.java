package com.gooks.blacklabel.common.handler;

import com.gooks.blacklabel.common.utils.CustomObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
* @package : com.gooks.blacklabel.common.handler
* @name : ApiHandler.java
* @date : 2022-12-14 오후 4:16
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 외부연동 API를 처리하는 핸들러
**/
@Slf4j(topic="API_DATA_EXCHANGE")
@Component
@AllArgsConstructor
public class ApiHandler {

    protected final RestTemplate restTemplate;
    protected final CustomObjectMapper objectMapper;
    
}
