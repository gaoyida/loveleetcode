package com.gaoyida.loveleetcode.search.breadthfirstsearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author gaoyida
 * @date 2019/7/21 下午4:02
 * <link>https://leetcode.com/problems/find-bottom-left-tree-value/</link>
 * 思路1：记录每层最左边的节点，返回最底层最左边的节点
 * 思路2：按照BFS-每层从右到左的顺序遍历，最后的节点就是结果。
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        TreeNode result = root;
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(root, 0);
        TreeNode[] leftArr = new TreeNode[100000];
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            int depth = depthMap.get(node) + 1;
            if (node != null && node.left != null) {
                queue.offerLast(node.left);
                depthMap.put(node.left, depth);
                if (leftArr[depth] == null) {
                    leftArr[depth] = node.left;
                    result = node.left;
                }
            }
            if (node != null && node.right != null) {
                queue.offerLast(node.right);
                depthMap.put(node.right, depth);
                if (leftArr[depth] == null) {
                    leftArr[depth] = node.right;
                    result = node.right;
                }
            }
        }
        return result.val;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new FindBottomLeftTreeValue().findBottomLeftValue(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

