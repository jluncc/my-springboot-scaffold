package com.example.scaffold.interceptor;

import com.example.scaffold.constant.BizConstant;
import com.example.scaffold.util.traceId.TraceIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截请求，设置traceId
 *
 * Created by jinglun on 2020-04-13
 */
public class TraceIdInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(BizConstant.TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            traceId = TraceIdUtil.getTraceId();
        }
        MDC.put(BizConstant.TRACE_ID, traceId);
        return true;
    }
}
