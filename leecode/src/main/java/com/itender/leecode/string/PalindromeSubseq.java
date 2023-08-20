package com.itender.leecode.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author itender
 * @date 2023/7/28 14:13
 * @desc
 */
@Slf4j
public class PalindromeSubseq {
    public static void main(String[] args) {
        String s = "cbbd";
        int length = longestPalindromeSubseq(s);
        System.out.println(length);
    }

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // 从后往前遍历 保证情况不漏
        for (int i = len - 1; i >= 0; i--) {
            // 初始化
            dp[i][i] = 1;
            log.info("初始化值：{}， i = {}", 1, i);
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    log.info("i = {}, j = {}, charAt[i] = {}, charAt[j] = {},  dp[i][j] = {}", i, j, s.charAt(i), s.charAt(j), dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                    log.info("i = {}, j = {}, charAt[i] = {}, charAt[j] = {},  dp[i][j] = {}, dp[i + 1][j] = {}, dp[i][j - 1] = {}", i, j, s.charAt(i), s.charAt(j), dp[i][j], dp[i + 1][j], dp[i][j - 1]);
                }
            }
            log.info("二维数组为：\r\n{}", Arrays.deepToString (dp).replace("],", "] \r\n"));
        }
        return dp[0][len - 1];
    }
}
