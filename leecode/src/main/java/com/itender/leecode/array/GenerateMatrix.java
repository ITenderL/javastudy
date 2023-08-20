package com.itender.leecode.array;

import java.util.Arrays;

/**
 * @author itender
 * @date 2023/8/18 15:32
 * @desc 螺旋矩阵
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * <p>
     * 示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     * <p>
     * 提示：
     * 1 <= n <= 20
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop = 1;
        int start = 0;
        int count = 1;
        int i;
        int j;
        while (loop <= n / 2) {
            // 从左到右 j++
            for (j = start; j < n - loop; j++) {
                result[start][j] = count++;
            }
            // 从上到下i++
            for (i = start; i < n - loop; i++) {
                result[i][j] = count++;
            }
            // 从右到左
            for (; j >= loop; j--) {
                result[i][j] = count++;
            }
            // 从下到上
            for (; i >= loop; i--) {
                result[i][j] = count++;
            }
            start++;
            loop++;
        }
        if (n % 2 == 1) {
            result[start][start] = count;
        }
        return result;
    }
}
