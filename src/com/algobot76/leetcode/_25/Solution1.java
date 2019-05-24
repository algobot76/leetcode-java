package com.algobot76.leetcode._25;

import com.algobot76.leetcode.util.ListNode;

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = getLen(head) / k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (count > 0) {
            ListNode next = curr.next;
            ListNode[] nodes = reverse(next, k);
            curr.next = nodes[0];
            next.next = nodes[1];
            curr = next;
            count--;
        }

        return dummy.next;
    }

    private int getLen(ListNode head) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }

    private ListNode[] reverse(ListNode n1, int k) {
        ListNode n2 = n1.next;
        while (n2 != null && k > 1) {
            ListNode next = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = next;
            k--;
        }

        return new ListNode[]{n1, n2};
    }
}
