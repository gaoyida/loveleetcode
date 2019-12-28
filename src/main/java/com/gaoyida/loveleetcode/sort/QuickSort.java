package com.gaoyida.loveleetcode.sort;

/**
 * @author gaoyida
 * @date 2019/11/20 上午11:20
 * 数组有n个元素，因为要递归运算，算出支点pivot的位置，然后递归调用左半部分和有半部分，
 * 这个时候理解上是若第一层的话就是n/2，n/2，若是第二层就是n/4,n/4,n/4,n/4这四部分，
 * 即n个元素理解上是一共有几层2^x=n，x=logn，然后每层都是n的复杂度，那么平均就是O(nlogn)的时间复杂度。
 * 但这种肯定是平均情况，如果你是标准排序的情况下，如果已经是ascending的顺序，那么递归只存在右半部分了，
 * 左半部分都被淘汰了。(n-1)*(n-2)*....*1，这个复杂度肯定就是O(n^2)，这种情况还不如用插入排序。
 *
 *
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);

    }

    //开始时，right指针向左移找比arr[0]小的数，left指针向右移动找比arr[0]大的数
    private static void sort(int[] arr, int left, int right) {
        int tmp = arr[left];
        int startIdx = left;
        int endIdx = right;
        do {
            while (arr[right] > tmp && right != left && right > 0) {
                right--;
            }
            while (arr[left] <= tmp && right != left && left < arr.length - 1) {
                left++;
            }
            if (left != right) {
                SortUtil.swap(arr, left, right);
            }
        } while (left != right);
        if (arr[left] < arr[startIdx]) {
            SortUtil.swap(arr, left, startIdx);
        }
        if (left - 1 > startIdx)
            sort(arr, startIdx, left - 1);
        if (left + 1 < endIdx)
            sort(arr, left + 1, endIdx);
    }
}
