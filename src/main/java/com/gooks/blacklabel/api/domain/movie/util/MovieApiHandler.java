package com.gooks.blacklabel.api.domain.movie.util;

import com.gooks.blacklabel.api.common.handler.RestTemplateHandler;
import com.gooks.blacklabel.api.common.utils.JwtHeaderHelper;
import com.gooks.blacklabel.common.utils.CustomObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MovieApiHandler extends RestTemplateHandler {
    //TODO 살펴보기
    public MovieApiHandler(RestTemplate restTemplate, JwtHeaderHelper jwtTokenHeader, CustomObjectMapper objectMapper) {
        super(restTemplate, jwtTokenHeader, objectMapper);
    }
}
