package com.example.scaffold.service.strategyMode;

import com.example.scaffold.constant.ArithmeticTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 策略生成工厂
 *
 * Created by jinglun on 2020-08-29
 */
@Component
public class ArithmeticStrategyFactory {

    // 收集不同的算术运算策略的Map
    private Map<Integer, ArithmeticStrategy> arithmeticStrategyMap;

    @Resource
    private ArithmeticDefaultStrategy arithmeticDefaultStrategy;
    @Resource
    private AdditionStrategy additionStrategy;
    @Resource
    private SubtractionStrategy subtractionStrategy;

    @PostConstruct
    private void init() {
        arithmeticStrategyMap = new HashMap<>();
        arithmeticStrategyMap.put(ArithmeticTypeEnum.ADDITION.getType(), additionStrategy);
        arithmeticStrategyMap.put(ArithmeticTypeEnum.SUBTRACTION.getType(), subtractionStrategy);
    }

    public ArithmeticStrategy get(Integer type) {
        return Optional.ofNullable(arithmeticStrategyMap.get(type)).orElse(arithmeticDefaultStrategy);
    }

}
