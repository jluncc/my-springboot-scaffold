package com.example.scaffold.util.traceId;

/**
 * 使用InheritableThreadLocal，新开的子线程可以从这里获取到父线程设置的traceId
 *
 * Created by jinglun on 2020-04-13
 */
public class TraceIdHolder {
    public static final InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal();

    public static String get() {
        return threadLocal.get();
    }

    public static void set(String traceId) {
        threadLocal.set(traceId);
    }
}
