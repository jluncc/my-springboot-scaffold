package com.example.scaffold.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志记录工具类
 *
 * 预定义不同的logger，使用时直接获取该logger进行打印，省去文件头部获取logger语句：
 * private static final Logger logger = LoggerFactory.getLogger(Class);
 *
 * 用法：
 * LogUtil.SYS.info();
 * LogUtil.ERR.error();
 *
 * Created by jinglun on 2020-04-12
 */
public class LogUtil {

    /**
     * 获取sys的logger，指定打印到scaffold-sys-%d{yyyy-MM-dd}.log文件。见logback.xml
     */
    public static Logger SYS = LoggerFactory.getLogger("sys");

    /**
     * 获取sys-error的logger，指定打印到scaffold-err-%d{yyyy-MM-dd}.log文件。见logback.xml
     * 注意：该logger的level="ERROR"，只有打印error级别日志才会输出
     */
    public static Logger ERR = LoggerFactory.getLogger("sys-error");

    /**
     * 获取请求日志的logger，指定打印到scaffold-access-%d{yyyy-MM-dd}.log文件。见logback.xml
     */
    public static Logger ACCESS = LoggerFactory.getLogger("access");

    // 示例，SYS可打印info级别以上的日志，ERR只可打印error级别日志
    public static void main(String[] args) {
        LogUtil.SYS.debug("这是测试，级别:{}", "debug");
        LogUtil.SYS.info("这是测试，级别:{}", "info");
        LogUtil.SYS.warn("这是测试，级别:{}", "warn");
        LogUtil.SYS.error("这是测试，级别:{}", "error");

        LogUtil.SYS.info("=========");

        LogUtil.ERR.debug("测试错误日志，级别:{}", "debug");
        LogUtil.ERR.info("测试错误日志，级别:{}", "info");
        LogUtil.ERR.warn("测试错误日志，级别:{}", "warn");
        LogUtil.ERR.error("测试错误日志，级别:{}", "error");
    }

}
