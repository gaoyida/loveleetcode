package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.Stack;
/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/validate-binary-search-tree/</link>
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        int pre = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (!flag) {
                pre = root.val;
                flag = true;
            } else {
                if (root.val <= pre) {
                    return false;
                }
                pre = root.val;
            }
            root = root.right;
        }
        return true;
    }


}
