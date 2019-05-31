package com.algobot76.leetcode._109;

import com.algobot76.leetcode.util.ListNode;
import com.algobot76.leetcode.util.TreeNode;

/**
 * Recursion (Bottom-Up)
 */
public class Solution1 {
    private ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode ptr = head;

        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        list = head;

        return sortedListToBST(0, len - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);

        return parent;
    }
}
