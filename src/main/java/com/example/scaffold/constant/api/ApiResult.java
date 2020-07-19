package com.example.scaffold.constant.api;

import com.example.scaffold.util.DateUtil;

/**
 * Created by jinglun on 2020-07-19
 */
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;
    private String responseTime;

    /** 自定义success/fail方法 */

    public static ApiResult success() {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ApiCode.SUCCESS.getCode());
        apiResult.setMsg(ApiCode.SUCCESS.getMsg());
        apiResult.setResponseTime();
        return apiResult;
    }

    public static ApiResult success(Object data) {
        ApiResult apiResult = success();
        apiResult.setData(data);
        apiResult.setResponseTime();
        return apiResult;
    }

    public static ApiResult fail() {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ApiCode.FAIL.getCode());
        apiResult.setMsg(ApiCode.FAIL.getMsg());
        apiResult.setResponseTime();
        return apiResult;
    }

    public static ApiResult fail(String msg) {
        ApiResult apiResult = fail();
        apiResult.setMsg(msg);
        apiResult.setResponseTime();
        return apiResult;
    }

    public static ApiResult fail(Integer code, String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        apiResult.setResponseTime();
        return apiResult;
    }

    public static ApiResult fail(Integer code, String msg, Object data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        apiResult.setData(data);
        apiResult.setResponseTime();
        return apiResult;
    }


    /** get/set方法 */

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime() {
        this.responseTime = DateUtil.formatDate(System.currentTimeMillis(), DateUtil.COMMON_DATE_FORMAT);
    }
}
