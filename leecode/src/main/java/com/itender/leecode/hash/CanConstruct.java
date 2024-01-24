package com.itender.leecode.hash;

/**
 * @author itender
 * @date 2023/8/29 15:52
 * @desc 赎金信
 */
public class CanConstruct {

    public static void main(String[] args) {
       String ransomNote = "aa";
       String magazine = "ab";
       System.out.println(canConstruct1(ransomNote, magazine));
    }

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * 示例 1：
     *
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * 示例 2：
     *
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * 示例 3：
     *
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] records = new int[26];
        for (char c : ransomNote.toCharArray()) {
            records[c - 'a'] -= 1;
        }
        for (char c : magazine.toCharArray()) {
            records[c - 'a'] += 1;
        }
        for (int i : records) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] chars = ransomNote.toCharArray();
        for (char c : magazine.toCharArray()) {
            for (char aChar : chars) {
                if (aChar == c) {
                    ransomNote = ransomNote.replaceFirst(String.valueOf(c), "");
                    chars = ransomNote.toCharArray();
                    break;
                }
            }
        }
        return chars.length == 0;
    }
}
