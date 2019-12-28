package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/11/20 上午10:47
 * 选择排序
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            if (idx != i)
                SortUtil.swap(arr, i, idx);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 8, 6, 4};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
