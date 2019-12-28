package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/binary-tree-postorder-traversal/</link>
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        walk(root, list);
        return list;
    }

    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        walk(node.left, list);
        walk(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);

                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);

        }
        return list;
    }
}
