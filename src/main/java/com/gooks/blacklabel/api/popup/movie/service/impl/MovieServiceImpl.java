package com.gooks.blacklabel.api.popup.movie.service.impl;

import com.gooks.blacklabel.api.popup.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public List<Object> searchMovieList(String title, String type, String year, String page) {
        log.info("title : {}, type : {}, year : {}, page : {}", title, type, year, page);
        return null;
    }
}
