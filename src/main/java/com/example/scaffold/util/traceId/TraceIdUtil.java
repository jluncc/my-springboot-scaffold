package com.example.scaffold.util.traceId;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jinglun on 2020-04-13
 */
public class TraceIdUtil {

    /**
     * 生成由8位字符组成的随机字符串traceId
     */
    public static String buildTraceId() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    /**
     * 生成给定的父线程tradeId-新的8位随机字符串traceId
     * @return parentTraceId-8位随机字符串
     */
    public static String buildChildThreadId(String parentTraceId) {
        return parentTraceId + "-" + RandomStringUtils.randomAlphanumeric(8);
    }

    /**
     * 从当前线程中获取traceId，若没有则自动生成一个traceId，再设置进当前线程的环境中
     */
    public static String getTraceId() {
        String traceId = TraceIdHolder.get();
        if (StringUtils.isEmpty(traceId)) {
            traceId = buildTraceId();
            TraceIdHolder.set(traceId);
        }
        return traceId;
    }

}
