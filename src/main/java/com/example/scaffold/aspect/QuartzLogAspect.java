package com.example.scaffold.aspect;

import com.example.scaffold.constant.BizConstant;
import com.example.scaffold.util.LogUtil;
import com.example.scaffold.util.traceId.TraceIdUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * 记录定时任务日志的切面
 *
 * Created by jinglun on 2020-04-13
 */
@Component
@Aspect
public class QuartzLogAspect {

    @Around("within(com.example.scaffold.quartz.*)")
    private Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        handleTraceId();

        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        LogUtil.SYS.info("[定时任务]{} —— 开始", methodName);
        Object obj = joinPoint.proceed();
        LogUtil.SYS.info("[定时任务]{} —— 结束，耗时:{}ms", methodName, System.currentTimeMillis() - start);
        return obj;
    }

    private void handleTraceId() {
        MDC.put(BizConstant.TRACE_ID, TraceIdUtil.buildTraceId());
    }

}
