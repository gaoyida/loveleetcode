package com.gaoyida.loveleetcode.search.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyida
 * @date 2019/12/28
 * <link>https://leetcode.com/problems/binary-tree-paths/</link>
 * 打印从根到叶子节点所有路径
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        if (root != null)
            dfs(root, list, s);
        return list;
    }

    private void dfs(TreeNode node, List<String> list, StringBuilder s) {
        //TODO
    }
}
