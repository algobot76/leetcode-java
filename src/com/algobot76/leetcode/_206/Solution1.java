package com.algobot76.leetcode._206;

import com.algobot76.leetcode.util.ListNode;

/**
 * Recursive
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
