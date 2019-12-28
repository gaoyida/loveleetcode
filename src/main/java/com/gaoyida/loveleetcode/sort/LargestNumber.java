package com.gaoyida.loveleetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gaoyida
 * @date 2019/12/28 下午9:48
 * @link https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] arrs = new String[nums.length];
        int idx = 0;
        for (int num : nums) {
            arrs[idx++] = String.valueOf(num);
        }
        Arrays.sort(arrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String tmp1 = o1 + o2;
                String tmp2 = o2 + o1;
                return tmp2.compareTo(tmp1);
            }
        });
        String result = "";
        for (String arr : arrs) {
            result += arr;
        }
        result = result.replaceFirst("^0*", "");
        if (result.equals("")) {
            result = "0";
        }
        return result;
    }
}
