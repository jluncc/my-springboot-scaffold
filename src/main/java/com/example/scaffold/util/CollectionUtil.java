package com.example.scaffold.util;

import java.util.*;

/**
 * 集合的工具类
 *
 * Created by jinglun on 2020-03-16
 */
public class CollectionUtil {
    /**
     * 判断集合是否为空
     * @param collection 被判断的集合
     * @return 空返回true，非空返回false
     */
    public static boolean collectionIsEmpty(Collection collection) {
        return collection.isEmpty();
    }

    /**
     * 判断集合是否为空
     * @param collection 被判断的集合
     * @return 空返回false，非空返回true
     */
    public static boolean collectionIsNotEmpty(Collection collection) {
        return !collection.isEmpty();
    }

    /**
     * 取两集合的交集
     * @param list1 集合1
     * @param list2 集合2
     * @param <E> 集合参数
     * @return 交集集合，若其中一个集合为空，则返回空集合
     */
    public static <E> List<E> getIntersection(List<E> list1, List<E> list2) {
        if (collectionIsEmpty(list1) || collectionIsEmpty(list2)) {
            return Collections.emptyList();
        }

        Set<E> hashSet;
        List<E> result;
        boolean list1LessThenList2 = true;
        if (list1.size() < list2.size()) {
            hashSet = new HashSet<>(list1);
            result = new ArrayList<>(list1.size() >> 1);
        } else {
            hashSet = new HashSet<>(list2);
            result = new ArrayList<>(list2.size() >> 1);
            list1LessThenList2 = false;
        }

        if (list1LessThenList2) {
            for (E item : list2) {
                if (hashSet.contains(item)) {
                    result.add(item);
                }
            }
        } else {
            for (E item : list1) {
                if (hashSet.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * 以集合1为基础，取集合2的差集
     * @param list1 集合1
     * @param list2 集合2
     * @param <E> 集合参数
     * @return 差集集合，若集合1为空，集合2为空，则返回集合2；若集合2为空，集合1非空，则返回集合1
     */
    public static <E> List<E> getDifference(List<E> list1, List<E> list2) {
        if (collectionIsEmpty(list1) && collectionIsNotEmpty(list2)) {
            return list2;
        }
        if (collectionIsEmpty(list2) && collectionIsNotEmpty(list1)) {
            return list1;
        }

        Set<E> hashSet;
        List<E> result;
        boolean list1LessThenList2 = true;
        if (list1.size() < list2.size()) {
            hashSet = new HashSet<>(list1);
            result = new ArrayList<>(list1.size() >> 1);
        } else {
            hashSet = new HashSet<>(list2);
            result = new ArrayList<>(list2.size() >> 1);
            list1LessThenList2 = false;
        }

        if (list1LessThenList2) {
            for (E item : list2) {
                if (!hashSet.contains(item)) {
                    result.add(item);
                }
            }
        } else {
            for (E item : list1) {
                if (!hashSet.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
