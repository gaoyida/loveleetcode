package com.gaoyida.loveleetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyida
 * @date 2019/12/28 下午2:12
 * <link>https://leetcode.com/problems/partition-labels/</link>
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partSizes = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return partSizes;
        }

        char[] charArray = s.toCharArray();
        int[] indexMap = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            indexMap[charArray[i] - 'a'] = i;
        }

        int startPos = 0;
        int endPos = 0;
        for (int i = 0; i < charArray.length; i++) {
            endPos = Math.max(endPos, indexMap[charArray[i] - 'a']);
            if (endPos == i) {
                partSizes.add(endPos - startPos + 1);
                startPos = endPos + 1;
            }
        }
        return partSizes;
    }
}
