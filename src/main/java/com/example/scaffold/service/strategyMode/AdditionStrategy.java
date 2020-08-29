package com.example.scaffold.service.strategyMode;

import org.springframework.stereotype.Component;

/**
 * 加法的策略
 *
 * Created by jinglun on 2020-08-29
 */
@Component
public class AdditionStrategy implements ArithmeticStrategy {
    @Override
    public int doCalculate(int x, int y) {
        return x + y;
    }
}
