package com.itender.leecode.array;

/**
 * @author itender
 * @date 2023/8/17 17:32
 * @desc
 */
public class MinSubArrayLen {
    public static void main(String[] args) {

    }

    /**
     * 209. 长度最小的子数组
     * 中等
     * 1.8K
     * 相关企业
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 提示：
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     */

    /**
     * 第一种方法：暴力求解，两层for循环
     * 暴力法是最直观的方法。初始化子数组的最小长度为无穷大，枚举数组 nums 中的每个下标作为子数组的开始下标，对于每个开始下标 i，
     * 需要找到大于或等于 i 的最小下标 j，使得从 nums[i] 到 nums[j] 的元素和大于或等于 s，
     * 并更新子数组的最小长度（此时子数组的长度是 j−i+1）。
     *
     * @param nums
     * @param s
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(j - i + 1, result);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    /**
     * 第一种方法：滑动窗口
     *
     * @param nums
     * @param s
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
