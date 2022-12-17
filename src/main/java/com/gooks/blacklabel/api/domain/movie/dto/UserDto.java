package com.gooks.blacklabel.common.aop.api.domain.movie.dto;

import lombok.*;

public class UserDto {
    public static class  Request {
        @Builder.Default private String name = "gil-dong";
        @Builder.Default private String nation = "Korea";
        @Builder.Default private String email = "gildong@gmail.com";
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class  Response {
        private String name;
        private String nation;
        private String email;
    }
}
