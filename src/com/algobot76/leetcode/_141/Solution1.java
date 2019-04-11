package com.algobot76.leetcode._141;

import com.algobot76.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Hash Table
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
