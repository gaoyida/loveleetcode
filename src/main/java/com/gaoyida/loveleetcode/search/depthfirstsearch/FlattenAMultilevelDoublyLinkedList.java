package com.gaoyida.loveleetcode.search.depthfirstsearch;

/**
 * @author gaoyida
 * @date 2019/12/27
 * <link>https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/</link>
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public static class Solution {
        public Node flatten(Node head) {
            dfs(head);
            return head;
        }

        public Node dfs(Node node) {

            while (node != null) {
                Node oldNext = node.next;
                if (node.child != null) {
                    Node child = node.child;
                    Node newNext = dfs(node.child);
                    node.next = child;
                    node.child = null;
                    child.prev = node;
                    newNext.next = oldNext;
                    if (oldNext == null) {
                        return newNext;
                    }
                    oldNext.prev = newNext;
                }
                if (oldNext == null) {
                    return node;
                }
                node = oldNext;
            }
            return null;
        }
    }
}

