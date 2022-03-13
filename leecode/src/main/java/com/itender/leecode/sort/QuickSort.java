package com.itender.leecode.sort;

import java.util.Arrays;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 14:36
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 19, 4, 15, 8, 2, 6, 11};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(i -> System.out.print(i + "  "));
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        int base = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr, left,  i - 1);
        quickSort(arr, j + 1, right);
    }
}
