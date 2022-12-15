package com.gooks.blacklabel.common.utils.biz;

import org.slf4j.MDC;

public final class ApiName {

    protected static final String HEADER_API_NAME = "apiName";

    private ApiName() {
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
