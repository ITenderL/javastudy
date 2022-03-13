package com.itender.leecode.problem;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-21 19:19
 * @Description: 股票最大抛出收益
 */
public class ArrayMaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }
}
