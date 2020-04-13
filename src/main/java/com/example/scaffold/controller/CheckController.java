package com.example.scaffold.controller;

import com.example.scaffold.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用的接口
 *
 * Created by jinglun on 2020-04-12
 */
@RestController
@RequestMapping("/scaffold/api/v1/check")
public class CheckController {

    @ApiOperation("[测试]测试接口")
    @GetMapping("/info")
    public String info() {
        LogUtil.SYS.info("000");
        testLog();
        LogUtil.SYS.info("333");
        return "Hello!";
    }

    private void testLog() {
        LogUtil.SYS.info("111");
    }

}
