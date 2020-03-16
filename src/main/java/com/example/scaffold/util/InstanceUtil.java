package com.example.scaffold.util;

import java.lang.reflect.Field;

/**
 * 对象工具类
 *
 * Created by jinglun on 2020-03-16
 */
public class InstanceUtil {

    /**
     * 判断传进对象是否为空对象
     * @return 对象各字段为空-true；否则-false
     */
    public static boolean isInstanceEmpty(Object obj) {
        boolean result = false;
        if (null == obj) return true;

        Class<?> clazz = obj.getClass();
        Field[] fs = clazz.getDeclaredFields();
        for (Field field : fs) { //遍历属性
            field.setAccessible(true); // 设置属性是可以访问的（私有的也可以）
            try {
                Object value = field.get(obj);
                if (value == null || value == "" || (value instanceof String && "null".equalsIgnoreCase((String) value))) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException("InstanceUtil isInstanceEmpty method has a Exception");
            }
        }
        return result;
    }
}
