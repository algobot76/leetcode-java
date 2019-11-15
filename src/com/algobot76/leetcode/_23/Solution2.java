package com.algobot76.leetcode._23;

import com.algobot76.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> newLists = new ArrayList<>();
            for (int i = 0; i + 1 < lists.length; i += 2) {
                ListNode mergedList = merge(lists[i], lists[i + 1]);
                newLists.add(mergedList);
            }
            if (lists.length % 2 == 1) {
                newLists.add(lists[lists.length - 1]);
            }
            lists = newLists.toArray(new ListNode[newLists.size()]);
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }
}
