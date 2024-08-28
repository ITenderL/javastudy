package com.itender.leecode.hash;

import java.util.Arrays;

/**
 * @author itender
 * @date 2023/8/23 9:57
 * @desc 242. 有效的字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "aee";
        String t = "eaea";
        System.out.println(isAnagram1(s, t));
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        // record数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;
    }


    public static boolean isAnagram1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
}
