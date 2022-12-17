package com.gooks.blacklabel.api.domain.movie.service;

import com.gooks.blacklabel.api.domain.movie.dto.MovieDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
* @package : com.gooks.blacklabel.api.movie.service
* @name : MovieService.java
* @date : 2022-12-14 오후 3:42
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description :
**/
public interface MovieService {
    ResponseEntity<Object> searchMovieList(String title, String type, String year, String page);
}
