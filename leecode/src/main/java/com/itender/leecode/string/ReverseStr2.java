package com.itender.leecode.string;

/**
 * @author itender
 * @date 2023/7/28 17:58
 * @desc
 */
public class ReverseStr2 {

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        System.out.println(reverse2(str, k));
    }

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     * 示例 2：
     * <p>
     * 输入：s = "abcd", k = 2
     * 输出："bacd"
     *
     * @param str
     * @param k
     */
    public static String reverse2(String str, int k) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
