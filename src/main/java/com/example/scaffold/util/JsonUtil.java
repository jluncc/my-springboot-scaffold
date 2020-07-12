package com.example.scaffold.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * Json工具类，底层使用Jackson
 *
 * Created by jinglun on 2020-07-12
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 设置日期格式化
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 驼峰转下划线
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        // 对象中为null的字段不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 对象为空时，是否报错，默认为true
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // json中含有对象类不存在的属性时是否报错，默认为true
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> String to(T obj) {
        if (null == obj) return null;
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T from(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
