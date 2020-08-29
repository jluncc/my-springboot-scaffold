package com.example.scaffold.constant;

/**
 * 算术运算策略类型枚举
 *
 * Created by jinglun on 2020-08-29
 */
public enum ArithmeticTypeEnum {
    ADDITION(1, "加法"),
    SUBTRACTION(2, "减法");

    private Integer type;
    private String name;

    ArithmeticTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
