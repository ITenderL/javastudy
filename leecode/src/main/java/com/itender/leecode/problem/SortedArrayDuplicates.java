package com.itender.leecode.problem;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 17:25
 * @descript: 双指针求数组中无重复元素的个数
 */
public class SortedArrayDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
