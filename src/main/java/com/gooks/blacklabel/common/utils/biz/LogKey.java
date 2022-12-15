package com.gooks.blacklabel.common.utils.biz;

import org.slf4j.MDC;

import java.util.UUID;

/**
* @package : com.gooks.blacklabel.common.utils
* @name : LogKey.java
* @date : 2022-12-14 오후 10:53
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 로그키 관리 클래스
**/
public final class LogKey {

    protected static final String HEADER_LOG_KEY = "logKey";

    private LogKey() {
    }

    public static String getLogKeyName() {
        return HEADER_LOG_KEY;
    }

    public static String get() {
        return MDC.get(HEADER_LOG_KEY);
    }

    public static void put(String keyValue) {
        MDC.put(HEADER_LOG_KEY, keyValue);
    }

    public static void remove() {
        MDC.remove(HEADER_LOG_KEY);
    }

    public static String createLogKey() {
        return UUID.randomUUID().toString();
    }
}

