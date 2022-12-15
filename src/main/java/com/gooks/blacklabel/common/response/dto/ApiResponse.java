package com.gooks.blacklabel.common.response.dto;

import java.time.LocalDate;

import com.gooks.blacklabel.api.common.utils.DateTimeUtils;
import com.gooks.blacklabel.common.utils.biz.LogKey;

import lombok.Getter;

/**
* @package : com.gooks.blacklabel.common.dto
* @name : ApiResponse.java
* @date : 2022-12-15 오전 9:13
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 공통응답 DTO
**/

@Getter
public final class ApiResponse {
    /**/
    private String logKey;

    private Object data;

    private String serverDt;

    public ApiResponse(Object data) {
        this.logKey = LogKey.get();
        this.data = data;
        this.serverDt = DateTimeUtils.formatHyphen(LocalDate.now());
    }
}
