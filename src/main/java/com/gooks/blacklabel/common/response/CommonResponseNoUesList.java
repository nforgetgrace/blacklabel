package com.gooks.blacklabel.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponseNoUesList {
    //name을 메소드명과 동일하게 정의할 것.
    ispSave("AirPaymentController","ispSave");

    private String className;   //클래스명
    private String methodName;  //메소드명
}
