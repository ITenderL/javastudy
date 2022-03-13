package com.itender.leecode.sort;

import java.util.Arrays;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 14:35
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 19, 4, 15, 8, 2, 6, 11};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + "  "));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
