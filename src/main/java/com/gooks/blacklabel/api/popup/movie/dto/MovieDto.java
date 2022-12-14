package com.gooks.blacklabel.api.popup.movie.dto;

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

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Builder
public class MovieDto {
    private String name = "gil-dong";
    private String nation = "Korea";
    private String email = "gildong@gmail.com";

    public static class  SearchParam {
        private String title;
        private String page;
        private String type;
        private String year;
    }
}
