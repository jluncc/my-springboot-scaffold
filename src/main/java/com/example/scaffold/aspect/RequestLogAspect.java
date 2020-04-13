package com.example.scaffold.aspect;

import com.alibaba.fastjson.JSON;
import com.example.scaffold.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 记录请求日志的切面
 *
 * Created by jinglun on 2020-04-13
 */
@Component
@Aspect
public class RequestLogAspect {

    @Around("within(com.example.scaffold.controller.*)")
    private Object logFilter(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        Object args[] = joinPoint.getArgs();
        long start = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
            this.log(request, args, result, start, false);
            return result;
        } catch (Exception e) {
            this.log(request, args, e.getMessage(), start, true);
            throw e;
        }
    }

    private void log(HttpServletRequest request, Object args[], Object result, long start, boolean isError) {
        long end = System.currentTimeMillis();
        String res = result.toString();
        if (!"GET".equals(request.getMethod()) || isError) {
            res = JSON.toJSONString(request);
        }
        long costTime = end - start;
        if (costTime > 5000) {
            LogUtil.ACCESS.warn("[{}]{}，参数:{}，返回:{}，耗时:{}ms。请求耗时超过5秒，请优化",
                    request.getMethod(), request.getRequestURI(), args, res, end - start);
        } else {
            LogUtil.ACCESS.info("[{}]{}，参数:{}，返回:{}，耗时:{}ms。",
                    request.getMethod(), request.getRequestURI(), args, res, end - start);
        }
    }

}
