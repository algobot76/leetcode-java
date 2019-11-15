package com.algobot76.leetcode._23;

import com.algobot76.leetcode.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            curr.next = head;
            curr = curr.next;
            if (head.next != null) {
                pq.offer(head.next);
            }
        }

        return dummyHead.next;
    }
}
