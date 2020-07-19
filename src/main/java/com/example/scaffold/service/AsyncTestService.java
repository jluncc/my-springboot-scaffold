package com.example.scaffold.service;

import com.example.scaffold.util.LogUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 测试线程池异步方法service类
 *
 * 使用@Async注解时，注意以下情况会失效
 * 1.调用方法与被调用的异步方法在同一个类中
 * 2.异步类类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象
 * 3.使用SpringBoot框架没有在启动类中增加@EnableAsync注解
 *
 * Created by jinglun on 2020-07-18
 */
@Service
public class AsyncTestService {

    // 显式声明为我们自定义的线程池，若不指定，则使用默认线程池
    @Async("myTaskExecutor")
    public void sayHi() throws InterruptedException {
        LogUtil.SYS.info("[sayHi]start");
        Thread.sleep(5000);
        LogUtil.SYS.info("[sayHi]end");
    }

}
