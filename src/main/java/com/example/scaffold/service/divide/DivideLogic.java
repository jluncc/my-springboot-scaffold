package com.example.scaffold.service.divide;

import com.example.scaffold.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 该方法总结了使用Math.min()方法优化切分集合逻辑
 *
 * Created by jinglun on 2020-08-31
 */
public class DivideLogic {

    /**
     * 使用Math.min()方法干掉if/else判断
     */
    private static void divideWithMinMethod(List<Integer> ids) {
        int startIndex = 0;
        int batchHandleSize = 4;
        int size = ids.size();
        while (startIndex < size) {
            List<Integer> subIds = ids.subList(startIndex, Math.min(startIndex + batchHandleSize, size));
            startIndex = startIndex + batchHandleSize;
            // 具体的处理逻辑
            subIds.forEach(integer -> LogUtil.SYS.info(integer.toString()));
        }
    }

    private static void divideWithoutMinMethod(List<Integer> ids) {
        int startIndex = 0;
        int batchHandleSize = 2;
        int size = ids.size();
        while (startIndex < size) {
            int handleEndIndex = startIndex + batchHandleSize;
            List<Integer> subIds = new ArrayList<>();
            if (handleEndIndex < size) {
                subIds = ids.subList(startIndex, handleEndIndex);
                startIndex = handleEndIndex;
            } else {
                subIds = ids.subList(startIndex, size);
                startIndex = size;
            }
            // 具体处理逻辑
            subIds.forEach(integer -> LogUtil.SYS.info(integer.toString()));
        }

    }

    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }};
        divideWithMinMethod(ids);
        LogUtil.SYS.info("=======");
        divideWithoutMinMethod(ids);
    }

}
