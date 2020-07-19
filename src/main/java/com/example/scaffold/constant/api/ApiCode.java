package com.example.scaffold.constant.api;

/**
 * 封装常用ApiCode
 *
 * Created by jinglun on 2020-07-19
 */
public enum ApiCode {

    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),

    SYSTEM_ERROR(-100, "系统错误"),

    PARAMS_MISSING(10001, "参数缺失"),
    URL_ERROR(20001, "请求路径错误");

    private Integer code;
    private String msg;

    ApiCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
