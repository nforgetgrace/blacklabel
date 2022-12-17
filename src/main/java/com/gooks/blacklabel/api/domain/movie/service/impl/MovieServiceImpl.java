package com.gooks.blacklabel.common.aop.api.domain.movie.service.impl;

import com.gooks.blacklabel.common.aop.api.domain.movie.dto.MovieDto;
import com.gooks.blacklabel.common.aop.api.domain.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @package : com.gooks.blacklabel.api.movie.service.impl
* @name : MovieServiceImpl.java
* @date : 2022-12-14 오후 3:32
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 샘풀 영화검색 API호출
**/

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Override
    public List<MovieDto.Response> searchMovieList(String title, String type, String year, String page) {
        log.info("title : {}, type : {}, year : {}, page : {}", title, type, year, page);
        List<MovieDto.Response> rtn = new ArrayList<>();

    /*
        try {
            URL url = new URL("dddd",);
            ResponseEntity<Object> response =new RestTemplate().getForEntity(url + "/board/{id}", Object.class, 3);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        //ResponseEntity<Object> response = new RestTemplate().postForEntity(url, request, Object.class);


     */
        rtn.add(MovieDto.Response.builder()
                .title("겨울왕국")
                .page("1")
                .type("영화")
                .year("2019")
                .build());
        return rtn;
    }
}
