package com.itender.leecode.sort;

import java.util.Arrays;

/**
 * @author : ITender
 * @date : 2022-02-20 14:36
 * @desc : 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 19, 4, 15, 3, 25, 7, 8, 2, 19, 9, 6, 11};
        quickSort(0, array.length - 1, array);
        System.out.println("quickSort : " + Arrays.toString(array));

        int[] array1 = new int[]{9, 19, 4, 15, 3, 25, 7, 8, 2, 19, 9, 6, 11};
        quickSort1(0, array1.length - 1, array1);
        System.out.println("quickSort1 : " + Arrays.toString(array1));
    }

    /**
     * 快速排序
     *
     * @param left
     * @param right
     * @param array
     */
    public static void quickSort(int left, int right, int[] array) {
        if (array == null || array.length == 0 || left > right) {
            return;
        }
        int i = left;
        int j = right;
        int index = array[i];
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
            }
            while (i < j && array[i] <= index) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = index;
        quickSort(left, i - 1, array);
        quickSort(i + 1, right, array);
    }

    /**
     * 快速排序
     *
     * @param left
     * @param right
     * @param array
     */
    public static void quickSort1(int left, int right, int[] array) {
        if (array == null || left > right) {
            return;
        }
        int i = left;
        int j = right;
        int index = array[i];
        // 一次排序
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            while (i < j && array[i] <= index) {
                i++;
            }
            if (i < j) {
                // 交换i和j位置的元素
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 交换基数的位置
        array[left] = array[i];
        array[i] = index;
        quickSort1(left, i - 1, array);
        quickSort1(i + 1, right, array);
    }
}
