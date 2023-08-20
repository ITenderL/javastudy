package com.itender.leecode.sort;

import java.util.Arrays;

/**
 * @author itender
 * @date 2022/10/27 18:32
 * @desc 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 19, 4, 15, 3, 25, 7, 8, 2, 6, 11};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序，每次选出最小的值放在被排序的数组的最前面
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
