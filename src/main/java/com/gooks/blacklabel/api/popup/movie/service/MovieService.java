package com.gooks.blacklabel.api.popup.movie.service;

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
    List<Object> searchMovieList(String title, String type, String year, String page);
}
