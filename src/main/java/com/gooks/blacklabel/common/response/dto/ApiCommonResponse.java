package com.gooks.blacklabel.common.response.dto;

import java.time.LocalDate;

import com.gooks.blacklabel.api.common.utils.DateTimeUtils;
import com.gooks.blacklabel.common.utils.mdc.LogKey;

import lombok.Getter;

/**
* @package : com.gooks.blacklabel.common.dto
* @name : ApiResponse.java
* @date : 2022-12-15 오전 9:13
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 공통응답 객체 data안에는 API메시지
**/

@Getter
public final class ApiCommonResponse {
    /**/
    private String logKey;

    private Object data;

    private String serverDt;

    public ApiCommonResponse(Object data) {
        this.logKey = LogKey.get();
        this.data = data; //API
        this.serverDt = DateTimeUtils.formatHyphen(LocalDate.now());
    }
}
