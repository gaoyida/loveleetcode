package com.gaoyida.loveleetcode.list;

/**
 * @author gaoyida
 * @date 2019/11/29 下午5:56
 * 链表翻转
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode node = null;
        while (head != null) {
            node = head.next;
            head.next=pre;
            pre=head;
            head=node;
        }
        return pre;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

