package com.example.scaffold.service.strategyMode;

import com.example.scaffold.MySpringbootScaffoldApplication;
import com.example.scaffold.constant.ArithmeticTypeEnum;
import com.example.scaffold.util.LogUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.runner.RunWith;

/**
 * Created by jinglun on 2020-08-29
 */
@SpringBootTest(classes = MySpringbootScaffoldApplication.class)
class ArithmeticStrategyFactoryTest {

    @Resource
    private ArithmeticStrategyFactory arithmeticStrategyFactory;

    @Test
    public void test() {
        int additionResult = arithmeticStrategyFactory.get(ArithmeticTypeEnum.ADDITION.getType()).doCalculate(10, 8);
        LogUtil.SYS.info("[test]additionResult:{}", additionResult);
        assertEquals(additionResult, 18);

        int subtractionResult = arithmeticStrategyFactory.get(ArithmeticTypeEnum.SUBTRACTION.getType()).doCalculate(10, 8);
        LogUtil.SYS.info("[test]subtractionResult:{}", subtractionResult);
        assertEquals(subtractionResult, 2);

        int defaultResult = arithmeticStrategyFactory.get(0).doCalculate(10, 8);
        LogUtil.SYS.info("[test]defaultResult:{}", defaultResult);
        assertEquals(defaultResult, 80);
    }

}