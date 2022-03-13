package com.itender.leecode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ITender
 * @Description:
 * @CreateTime: 2022-02-19 14:41
 */
public class MoveArray {
    public static void main(String[] args) {
        // int nums[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        // newArray(nums, 3);
        int nums[] = new int[]{1, 1, 2};

    }

    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            if(!list.contains(i)) {
                list.add(i);
            }
        }
        return list.size();
    }

    public static void newArray(int[] nums, int k) {
        int fast = k;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            fast = fast % nums.length;
            res[fast] = nums[i];
            fast++;
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}
