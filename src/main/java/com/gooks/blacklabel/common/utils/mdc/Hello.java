package com.gooks.blacklabel.common.utils.mdc;

import org.slf4j.MDC;

/**
* @package : com.gooks.blacklabel.common.utils.mdc
* @name : Hello.java
* @date : 2022-12-16 오후 2:13
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : MDC 로깅용
**/
public final class Hello {

    protected static final String HEADER_API_NAME = "hello";

    private Hello() {
    }

    public static String getApiName() {
        return HEADER_API_NAME;
    }

    public static String get() {
        return MDC.get(HEADER_API_NAME);
    }

    public static void put(String keyValue) {
        MDC.put(HEADER_API_NAME, keyValue);
    }

    public static void remove() {
        MDC.remove(HEADER_API_NAME);
    }
}
