package com.itender.newfeature;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuanhewei
 * @date 2024/7/1 10:00
 * @description
 */
public class ListEqualsOrNot {
    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("hello", "world");
        List<String> list2 = Lists.newArrayList("world", "hello");
        // System.out.println("containsAll: " + compareByContainsAll(list, list2));
        // System.out.println("for循环：" + compareByFor(list, list2));
        System.out.println("retainAll：" + compareByRetainAll(list, list2));
    }

    /**
     * 方法一：使用list中的containsAll方法，此方法是判断list2是否是list的子集，即list2包含于list
     *
     * @param list
     * @param list2
     */
    public static boolean compareByContainsAll(List<String> list, List<String> list2) {
        boolean flag = false;
        if (list.size() == list2.size()) {
            if (list.containsAll(list2)) {
                flag = true;
            }
        }
        return flag;
    }


    /**
     * 方法二：使用for循环遍历+contains方法
     *
     * @param list
     * @param list2
     */
    public static boolean compareByFor(List<String> list, List list2) {
        boolean flag = false;
        if (list.size() == list2.size()) {
            for (String str : list) {
                if (!list2.contains(str)) {
                    System.out.println(flag);
                    return flag;
                }
            }
            flag = true;
        }
        return flag;
    }


    //方法四：使用list.retainAll()方法，此方法本质上是判断list是否有移除操作，如果list2是list的子集则不进行移除返回false，否则返回true
    //如果集合list2中的元素都在集合list中则list2中的元素不做移除操作，反之如果只要有一个不在list中则会进行移除操作。即：list进行移除操作返回值为：true反之返回值则为false。
    public static boolean compareByRetainAll(List<String> list,List list2){
        boolean flag = false;
        if (list.size()==list2.size()){
            if (!list.retainAll(list2)){
                flag = true;
            }
            System.out.println("方法四："+flag);
        }
        return flag;
    }
}
