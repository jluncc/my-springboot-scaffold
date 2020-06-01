package com.example.scaffold.quartz;

import com.example.scaffold.util.LogUtil;
import org.springframework.stereotype.Component;

/**
 * Created by jinglun on 2020-04-13
 */
@Component
public class CheckQuartz {

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void checkQuartz() {
        LogUtil.SYS.info("111");
        testLog();
        LogUtil.SYS.info("333");
    }

    private void testLog() {
        LogUtil.SYS.info("222");
    }
}
