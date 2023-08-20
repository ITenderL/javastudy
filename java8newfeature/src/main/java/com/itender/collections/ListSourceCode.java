package com.itender.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itender
 * @date 2022/10/24 14:53
 * @desc list源码解读
 */
public class ListSourceCode {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        // a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
