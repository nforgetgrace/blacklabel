package com.gooks.blacklabel.api.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter hyphenDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter noDelimiterDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");

    public static String format(LocalDate date) {
        return dateFormatter.format(date);
    }

    public static String formatHyphen(LocalDate date) {
        return hyphenDateFormatter.format(date);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTimeFormatter.format(dateTime);
    }

    public static String formatNoDelimiter(LocalDateTime dateTime) {
        return noDelimiterDateTimeFormatter.format(dateTime);
    }
}
