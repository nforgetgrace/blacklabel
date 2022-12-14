package com.gooks.blacklabel.api.popup.movie.dto;

import lombok.*;
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class SampleDto {
    @Builder.Default private String name = "gil-dong";
    @Builder.Default private String nation = "Korea";
    @Builder.Default private String email = "gildong@gmail.com";
}
