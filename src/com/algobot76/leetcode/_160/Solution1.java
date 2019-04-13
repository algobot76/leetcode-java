package com.algobot76.leetcode._160;

import com.algobot76.leetcode.util.ListNode;

/**
 * Two Pointers
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptrA = headA;
        ListNode ptrB = headB;
        if (ptrA == ptrB) {
            return ptrA;
        }
        while (ptrA != null && ptrB != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if (ptrA == null) {
            ptrA = headB;
        } else {
            ptrB = headA;
        }
        while (ptrA != null && ptrB != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if (ptrA == null) {
            ptrA = headB;
        } else {
            ptrB = headA;
        }
        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return null;
    }
}
