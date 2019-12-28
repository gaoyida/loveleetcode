package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/11/20 上午10:54
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
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
