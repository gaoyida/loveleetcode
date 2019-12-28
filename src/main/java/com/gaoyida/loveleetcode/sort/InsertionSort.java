package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/7/25 下午12:12
 * 插入排序
 */

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];
            for (; j > 0 && target < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = target;
        }
    }

}
