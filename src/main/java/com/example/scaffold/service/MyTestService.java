package com.example.scaffold.service;

import com.example.scaffold.util.LogUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jinglun on 2020-07-18
 */
@Service
public class MyTestService {
    @Resource
    private AsyncTestService asyncTestService;

    public void testAsyncMethod() {
        LogUtil.SYS.info("[testAsyncMethod]start");
        try {
            asyncTestService.sayHi();
        } catch (InterruptedException e) {
            LogUtil.ERR.error("[testAsyncMethod]catch exception.", e);
        }
        LogUtil.SYS.info("[testAsyncMethod]end");
    }
}
