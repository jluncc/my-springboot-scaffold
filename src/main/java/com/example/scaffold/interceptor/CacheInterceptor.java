package com.example.scaffold.interceptor;

import com.example.scaffold.annotation.CaCheMap;
import com.example.scaffold.annotation.MethodCache;
import com.example.scaffold.annotation.ParamCache;
import com.example.scaffold.util.JsonUtil;
import com.example.scaffold.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理自定义缓存注解的逻辑
 *
 * Created by jinglun on 2020-09-20
 */
@Aspect
@Component
public class CacheInterceptor {

    @Pointcut("@annotation(com.example.scaffold.annotation.MethodCache)")
    public void cache() {}

    @Around("cache()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        MethodCache methodCache = method.getAnnotation(MethodCache.class);
        Parameter[] parameters = method.getParameters();

        boolean useCache = true;
        List<String> paramList = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(ParamCache.class)) {
                ParamCache paramCache = parameters[i].getAnnotation(ParamCache.class);
                if (paramCache.notNull() && args[i] == null) {
                    useCache = false;
                    break;
                }
                if (args[i] != null) paramList.add(args[i].toString());
            }
        }

        if (!useCache) {
            LogUtil.SYS.info("[doAround]跳过缓存...");
            return joinPoint.proceed();
        }

        if (CollectionUtils.isEmpty(paramList)) {
            LogUtil.SYS.info("[doAround]参数为空...");
            throw new Exception("参数为空！缓存：" + methodCache.key());
        }

        String cacheKeyName = buildCacheKeyName(methodCache.key(), paramList);
        Object result;

        if (CaCheMap.memory.containsKey(cacheKeyName)) {
            String value = CaCheMap.memory.get(cacheKeyName);
            result = JsonUtil.from(value, method.getGenericReturnType());
            if (result == null) {
                LogUtil.SYS.info("[doAround]查询缓存获取为空...");
            } else {
                return result;
            }
        }

        result = joinPoint.proceed();
        if (result != null) {
            // TODO 过期时间待实现
            CaCheMap.memory.put(cacheKeyName, JsonUtil.to(result));
        }
        return result;
    }

    private String buildCacheKeyName(String key, List<String> paramList) {
        if (CollectionUtils.isEmpty(paramList)) return "";
        StringBuilder sb = new StringBuilder(key);
        for (String param : paramList) {
            sb.append("_");
            sb.append(param);
        }
        return sb.toString();
    }

}
