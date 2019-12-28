package com.gaoyida.loveleetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyida
 * @date 2019/12/28 下午9:43
 * <link>https://leetcode.com/problems/number-of-equivalent-domino-pairs/</link>
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int length = dominoes.length;
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (dominoes[i][0] < dominoes[i][1]) {
                list.add(dominoes[i][0] * 10 + dominoes[i][1]);
            } else {
                list.add(dominoes[i][1] * 10 + dominoes[i][0]);
            }
        }
        list.sort(Integer::compareTo);
        int cnt = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (list.get(i).equals(list.get(j))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
