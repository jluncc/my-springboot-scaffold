package com.example.scaffold.util.traceId;

/**
 * Created by jinglun on 2020-04-13
 */
public class TraceIdHolder {
    public static final InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal();

    public static String get() {
        return (String)threadLocal.get();
    }

    public static void set(String traceId) {
        threadLocal.set(traceId);
    }
}
