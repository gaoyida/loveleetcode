package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/binary-tree-preorder-traversal/</link>
 */
public class BinaryTreePreorderTraversal {
    /**
     * 迭代写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        walk(root, list);
        return list;
    }

    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        walk(node.left, list);
        walk(node.right, list);
    }


}
