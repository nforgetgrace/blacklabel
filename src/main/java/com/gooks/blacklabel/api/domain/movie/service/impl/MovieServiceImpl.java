package com.gooks.blacklabel.api.domain.movie.service.impl;

import com.gooks.blacklabel.api.domain.movie.dto.MovieDto;
import com.gooks.blacklabel.api.domain.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
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
    public ResponseEntity<Object> searchMovieList(String title, String type, String year, String page) {
        log.info("title : {}, type : {}, year : {}, page : {}", title, type, year, page);
        List<MovieDto.Response> rtn = new ArrayList<>();
        ResponseEntity<Object> response = null;

        try {
            URL url = new URL("htt://www.omdbapi.com/?apikey=ae898d58&s=frozen&type=movie&y=2019&page=1");
            response =new RestTemplate().getForEntity(url + "/board/{id}", Object.class, 3);
            log.info("MOVIE response", response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //ResponseEntity<Object> response = new RestTemplate().postForEntity(url, request, Object.class);

        return response;
    }
}
