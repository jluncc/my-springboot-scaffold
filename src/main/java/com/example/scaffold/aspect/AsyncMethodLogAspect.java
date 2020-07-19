package com.example.scaffold.aspect;

import com.example.scaffold.constant.BizConstant;
import com.example.scaffold.util.traceId.TraceIdUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * 拦截@Async注解，将父线程的traceId传递给子线程
 *
 * Created by jinglun on 2020-07-18
 */
@Component
@Aspect
public class AsyncMethodLogAspect {

    /**
     * 拦截@Async注解，传递父线程的traceId给子线程
     */
    @Around("@annotation(org.springframework.scheduling.annotation.Async)")
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        MDC.put(BizConstant.TRACE_ID, TraceIdUtil.buildChildThreadId(TraceIdUtil.getTraceId()));
        return joinPoint.proceed();
    }

}
