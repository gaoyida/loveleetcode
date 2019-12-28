package com.gaoyida.loveleetcode.search.binarysearchtree;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/unique-binary-search-trees/</link>
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[1] = 1;
        return calc(arr, n);
    }

    int calc(int[] a, int i) {
        if (a[i] != 0) {
            return a[i];
        }

        for (int j = 0; j <= i - 1; j++) {
            a[i] += calc(a, j) * calc(a, i - 1 - j);
        }
        return a[i];
    }
}