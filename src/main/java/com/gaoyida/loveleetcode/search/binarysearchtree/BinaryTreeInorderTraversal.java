package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/binary-tree-inorder-traversal/</link>
 * 二叉树后序遍历
 * 1. 递归
 * 2. 迭代
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalRecursively(root, new ArrayList<>());
//        return inorderTraversalIteratively(root);
    }

    private List<Integer> inorderTraversalRecursively(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        inorderTraversalRecursively(node.left, list);
        list.add(node.val);
        inorderTraversalRecursively(node.right, list);
        return list;
    }

    private List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
