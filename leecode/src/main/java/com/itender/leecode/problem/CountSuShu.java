package com.itender.leecode.problem;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 16:54
 * @des: 统计n之内素数的个数
 */
public class CountSuShu {

    public static void main(String[] args) {

        System.out.println(bf(100));
    }

    /**
     * 暴力算法
     *
     * @param n
     * @return
     */
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int j = 2; j < x; j++) {
            if (x % j == 0) {
                return false;
            }
        }
        return true;
    }
}
