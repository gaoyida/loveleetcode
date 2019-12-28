package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/11/20 上午10:49
 */
public class SortUtil {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{5, 3, 8, 6, 4};
        int[] a = new int[]{5, 4, 3, 2, 1};
//        InsertSort.insertSort(a);
        QuickSort.quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
