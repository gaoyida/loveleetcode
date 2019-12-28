package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.Stack;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/minimum-distance-between-bst-nodes/</link>
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int diff = -1;
        int a = 0, b = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (diff == -1) {
                a = root.val;
                diff = 0;
            } else {
                b = root.val;
                if (diff == 0) {
                    diff = Math.abs(a - b);
                } else {
                    diff = Math.abs(a - b) < diff ? Math.abs(a - b) : diff;
                }
                a = b;
            }
            root = root.right;
        }
        return diff;
    }
}
