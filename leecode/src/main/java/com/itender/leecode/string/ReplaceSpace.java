package com.itender.leecode.string;

/**
 * @author itender
 * @date 2023/8/30 17:03
 * @desc 替换空格
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
