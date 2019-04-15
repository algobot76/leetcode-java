package com.algobot76.leetcode._234;

import com.algobot76.leetcode.util.ListNode;

public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode ptrA = head;
        ListNode ptrB = reverse(slow);
        while (ptrB != null) {
            if (ptrA.val != ptrB.val) {
                return false;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
