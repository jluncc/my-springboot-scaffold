package com.example.scaffold.quartz;

import com.example.scaffold.constant.BizConstant;
import com.example.scaffold.util.LogUtil;
import com.example.scaffold.util.traceId.TraceIdUtil;
import org.slf4j.MDC;

/**
 * 定时任务执行逻辑的模板
 *
 * Created by jinglun on 2020-08-29
 */
public abstract class BaseQuartz {

    public void run() {
        MDC.put(BizConstant.TRACE_ID, TraceIdUtil.buildTraceId());

        if (isAbort()) return;

        long start = System.currentTimeMillis();
        String quartzName = this.getClass().getSimpleName();
        LogUtil.SYS.info("[定时任务] {} 开始...", quartzName);

        try {
            execute();
        } catch (Exception e) {
            LogUtil.ERR.error("[定时任务] {} 出错!", quartzName, e);
        }
        LogUtil.SYS.info("[定时任务] {} 结束 - 耗时: {} 毫秒。", quartzName, System.currentTimeMillis() - start);
    }

    /**
     * 定时任务是否需要中断执行
     */
    public abstract boolean isAbort();

    /**
     * 定时任务执行的具体逻辑
     */
    public abstract void execute();

}
