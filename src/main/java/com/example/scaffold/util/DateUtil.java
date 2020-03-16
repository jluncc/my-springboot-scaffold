package com.example.scaffold.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期的工具类
 *
 * Created by jinglun on 2020-03-16
 */
public class DateUtil {

    /**
     * 根据传进的日期格式，及字符串日期，转成对应Date对象
     * @param stringDate 字符串日期
     * @param pattern 日期格式，如 yyyy-MM-dd
     * @return Date对象的日期
     * @throws ParseException
     */
    public static Date strToDate(String stringDate, String pattern) throws ParseException {
        if (StringUtils.isBlank(stringDate)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = format.parse(stringDate);
        return date;
    }
}
