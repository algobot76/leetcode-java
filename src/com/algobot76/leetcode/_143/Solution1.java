package com.algobot76.leetcode._143;

import com.algobot76.leetcode.util.ListNode;

public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
