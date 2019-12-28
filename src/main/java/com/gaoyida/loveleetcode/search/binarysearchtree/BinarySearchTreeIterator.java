package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.LinkedList;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/binary-search-tree-iterator/</link>
 */
public class BinarySearchTreeIterator {
    private LinkedList<TreeNode> list = new LinkedList<>();

    public BinarySearchTreeIterator(TreeNode root) {
        list.clear();
        while (root != null) {
            list.add(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode last = list.removeLast();
        int val = last.val;
        last = last.right;
        while (last != null) {
            list.add(last);
            last = last.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list != null && !list.isEmpty();
    }
}
