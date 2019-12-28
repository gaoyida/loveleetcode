package com.gaoyida.loveleetcode.search.binarysearchtree;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/</link>
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return find(root, q, p);
        }
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val < p.val) {
            return find(root.right, p, q);
        }
        return find(root.left, p ,q);
    }
}
