package com.example.scaffold.quartz;

import com.example.scaffold.util.LogUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jinglun on 2020-04-13
 */
@Component
public class CheckQuartz extends BaseQuartz {

    @Override
    @Scheduled(cron = "0/20 * * * * ?")
    public void run() {
        super.run();
    }

    @Override
    public boolean isAbort() {
        return false;
    }

    @Override
    public void execute() {
        checkQuartz();
    }

    public void checkQuartz() {
        LogUtil.SYS.info("111");
        testLog();
        LogUtil.SYS.info("333");
    }

    private void testLog() {
        LogUtil.SYS.info("222");
    }
}
