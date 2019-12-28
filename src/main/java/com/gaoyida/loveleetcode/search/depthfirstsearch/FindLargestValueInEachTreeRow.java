package com.gaoyida.loveleetcode.search.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyida
 * @date 2019/7/21
 * <link>https://leetcode.com/problems/find-largest-value-in-each-tree-row/</link>
 */
public class FindLargestValueInEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> maxValueList = new ArrayList<>();
            dfs(root, maxValueList, 0);
            return maxValueList;
        }

        private void dfs(TreeNode node, List<Integer> maxValueList, int depth) {
            if (node == null) {
                return;
            }
            if (maxValueList.size() == depth) {
                maxValueList.add(node.val);
            } else {
                maxValueList.set(depth, Math.max(maxValueList.get(depth), node.val));
            }
            dfs(node.left, maxValueList, depth + 1);
            dfs(node.right, maxValueList, depth + 1);
        }
    }
}
