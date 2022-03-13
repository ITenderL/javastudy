package com.itender.leecode.search;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 14:36
 * @Description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 8, 11, 18};
        System.out.println(binarySearch(arr, 2));
    }

    /**
     * 二分查找:如果相等，返回下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
