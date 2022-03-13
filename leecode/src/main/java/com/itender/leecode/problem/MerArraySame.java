package com.itender.leecode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-21 18:58
 * @Description: 合并两个数组交集
 */
public class MerArraySame {
    public static void main(String[] args) {

    }

    public static int[] merge(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (list.contains(j)) {
                res.add(j);
            }
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }
}
