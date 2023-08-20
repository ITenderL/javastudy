package com.itender.leecode.string;

import java.util.Arrays;

/**
 * @author itender
 * @date 2023/7/28 17:58
 * @desc
 */
public class ReverseStr {

    public static void main(String[] args) {
        String str = "abcdefg";
        // char[] array = str.toCharArray();
        // reverse1(array);
        // System.out.println(Arrays.toString(array));
        System.out.println(reverse2(str));
    }

    public static void reverse1(char[] s) {
        int left = 0, right = s.length -1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverse2(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
