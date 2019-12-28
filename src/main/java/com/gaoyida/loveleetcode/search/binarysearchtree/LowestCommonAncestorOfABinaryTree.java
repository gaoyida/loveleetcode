package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/</link>
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> ppath = findPath(root, p, new ArrayList<>());
        List<TreeNode> qpath = findPath(root, q, new ArrayList<>());
        Map<TreeNode, Integer> pmap = new HashMap<>();
        for (TreeNode treeNode : ppath) {
            pmap.put(treeNode, treeNode.val);
        }
        for (int i = qpath.size() - 1; i >= 0; i--) {
            if (pmap.get(qpath.get(i)) != null) {
                return qpath.get(i);
            }
        }
        return null;
    }

    private List<TreeNode> findPath(TreeNode node, TreeNode p, List<TreeNode> list) {
        if (node.val == p.val) {
            return list;
        }
        list.add(node);
        if (node.val > p.val) {
            return findPath(node.left, p, list);
        }
        return findPath(node.right, p, list);
    }
}
