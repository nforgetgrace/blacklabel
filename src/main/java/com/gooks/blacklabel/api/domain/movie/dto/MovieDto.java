package com.gooks.blacklabel.common.aop.api.domain.movie.dto;

import lombok.*;

/**
* @package : com.gooks.blacklabel.api.movie.dto
* @name : MovieDto.java
* @date : 2022-12-14 오후 3:42
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description :
**/

public class MovieDto {

    public static class Request {
        private String title;
        private String page;
        private String type;
        private String year;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    @Builder
    public static class  Response {
        private String title;
        private String page;
        private String type;
        private String year;
    }
}
