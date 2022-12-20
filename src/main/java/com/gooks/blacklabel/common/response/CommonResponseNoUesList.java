package com.gooks.blacklabel.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
* @package : com.gooks.blacklabel.common.response
* @name : CommonResponseNoUesList.java
* @date : 2022-12-19 오후 3:47
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : ResponseAdvice에 결정에 따라 공통응답을 처리할지 말지 결정하기 때문에 공통응답을 사용하지 않을 메소드 이름 리스트 정의 클래스
**/
@Getter
@AllArgsConstructor
public enum CommonResponseNoUesList {
    //name을 메소드명과 동일하게 정의할 것.
    ispSave("AirPaymentController","ispSave");

    private String className;   //클래스명
    private String methodName;  //메소드명
}
