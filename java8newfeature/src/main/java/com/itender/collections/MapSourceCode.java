package com.itender.collections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author itender
 * @date 2022/10/19 16:58
 * @desc hashMap源码
 */
public class MapSourceCode {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Map<String, String> map = new HashMap<>(16);
        map.put("hello", "itender");
        Class<? extends Map> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));
        System.out.println(tableSizeFor(3));

        System.out.println(3 >>> 1);

        System.out.println(1 << 30);

        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

        Map<String, String> hashTable = new Hashtable<>();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
        }
    }


    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 16) ? 16 : n + 1;
    }
}
