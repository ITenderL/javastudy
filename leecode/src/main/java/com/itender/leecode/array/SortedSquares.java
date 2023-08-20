package com.itender.leecode.array;

import java.util.Arrays;

/**
 * @author itender
 * @date 2023/8/16 17:55
 * @desc
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        // System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquares2(nums)));

    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     * <p>
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * <p>
     *
     *
     * 第一种方法：暴力解法，每个元素求平方之后排序
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 第二种方法：双指针
     * 如果right指针的元素的平方 大于  左指针的元素的平方  right--；
     * 否则： 结果right位置的元素为 左指针元素的平方
     */
    public static int[] sortedSquares2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            if (nums[right]* nums[right] > nums[left] * nums[left]) {
                result[index] = nums[right]* nums[right];
                index--;
                right--;
            } else {
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            }
        }
        return result;
    }
}
