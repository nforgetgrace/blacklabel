package com.gooks.blacklabel.common.aop.api.domain.movie.controller;

import com.gooks.blacklabel.common.aop.api.domain.movie.dto.MovieDto;
import com.gooks.blacklabel.common.aop.api.domain.movie.dto.UserDto;
import com.gooks.blacklabel.common.aop.api.domain.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @package : com.gooks.blacklabel.api.movie.controller
* @name : MovieController.java
* @date : 2022-12-14 오전 10:20
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 샘플 컨트롤러
**/

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
public class MovieController {

    private final MovieService movieService;
    @GetMapping("/get")
    @Description("테스트 get 함수")
    public String get(@RequestParam String name){
        return name;
    }

    @GetMapping("/search/movie")
    @Description("영화를 검색한다.")
    public List<MovieDto.Response> movieSearch(@RequestParam String title,
                                               @RequestParam String year,
                                               @RequestParam String type,
                                               @RequestParam String page){

        return movieService.searchMovieList(title, year, type, page);
    }

    @PostMapping("/post")
    @Description("테스트 post 함수")
    public UserDto post(@RequestBody UserDto param){
        return param;
    }
}
