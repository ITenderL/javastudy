package com.itender.leecode.problem;

import java.util.Arrays;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 17:44
 * @Descript: 求数组的中间下标，要求中间的index的左右两边的元素的和相等
 */
public class ArrayMidIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
