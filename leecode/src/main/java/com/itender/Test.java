package com.itender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author analytics
 * @date 2024/11/18 14:23
 * @description 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。
 * 存在不合法的输入的话输出-1
 * <p>
 * <p>
 * 输入：
 * [2,3,1,0,2,5,3]
 * 返回值：
 * 2，3
 */
public class Test {
    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 0, 2, 5, 3};
        // findRepeatNumber(nums);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(2);
        list2.add(3);
        list = list.stream().distinct().filter(list2::contains).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    private static void findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                count = count + 1;
                map.put(nums[i], count);
                continue;
            }
            map.put(nums[i], 1);
        }
        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k);
            }
        });
    }
}
