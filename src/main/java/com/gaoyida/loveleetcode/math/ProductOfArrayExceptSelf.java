package com.gaoyida.loveleetcode.math;

/**
 * @author gaoyida
 * @date 2019/4/15 下午4:33
 * <link>https://leetcode.com/problems/product-of-array-except-self/</link>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    /**
     * 先遍历一遍
     * <p>
     * num[0] = 1
     * num[1] = num[0]
     * num[2] = num[0] * num[1]
     * ...
     * num[n-1] = num[0] * num[1] ... * num[n-2] (mark as newnum[n-1])
     * <p>
     * 再逆序遍历一遍
     * <p>
     * num[n-1] = newnum[n-1] * 1
     * num[n-2] = newnum[n-2] (num[0] * num[1] * ... * num[n-3]) * num[n-1]
     * num[n-3] = newnum[n-3] (num[0] * num[1] * ... * num[n-3] * num[n-4]) * num[n-1] * num[n-2]
     * ...
     * num[2] = newnum[2] (num[0] * num[1]) * num[n-1] * num[n-2] * ... * num[3]
     * num[1] = newnum[1] (num[0]) * num[n-1] * num[n-2] * ... * num[3] * num[2]
     * num[0] = newnum[0] (1) * num[n-1] * num[n-2] * ... * num[3] * num[2] * num[1]
     * 时间复杂度O(n)  空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            ret[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            ret[i] *= tmp;
            tmp *= nums[i];
        }
        return ret;
    }
}
