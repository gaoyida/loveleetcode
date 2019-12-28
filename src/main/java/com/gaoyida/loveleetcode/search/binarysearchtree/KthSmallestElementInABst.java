package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/kth-smallest-element-in-a-bst/</link>
 */
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTravesal(root, list);
        return list.get(k);
    }

    private void inorderTravesal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTravesal(node.left, list);
        list.add(node.val);
        inorderTravesal(node.right, list);
    }
}
