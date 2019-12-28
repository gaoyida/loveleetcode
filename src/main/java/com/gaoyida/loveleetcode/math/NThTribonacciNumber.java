package com.gaoyida.loveleetcode.math;

/**
 * @author gaoyida
 * @date 2019/12/28 下午9:11
 * <link>https://leetcode.com/problems/n-th-tribonacci-number/</link>
 */
public class NThTribonacciNumber {
    public int tribonacci(int n) {
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        return func(n, arr);
    }

    int func(int n, int[] arr) {
        if (arr[n] != 0 || n != 0) {
            return arr[n];
        }

        return func(n - 1, arr) + func(n - 2, arr) + func(n - 3, arr);
    }
}
