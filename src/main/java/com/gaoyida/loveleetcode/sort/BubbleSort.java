package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/11/20 上午10:28
 * 冒泡排序，从后向前，每次循环将较小/大的数往前冒
 */
public class BubbleSort {


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                }

            }
        }
    }

}
