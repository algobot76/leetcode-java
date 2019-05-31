package com.algobot76.leetcode._116;

import com.algobot76.leetcode.util.Node;

public class Solution1 {
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        while (root.left != null) {
            Node prev = root;
            while (root != null) {
                root.left.next = root.right;
                root.right.next = (root.next != null) ? root.next.left : null;
                root = root.next;
            }
            root = prev.left;
        }
    }
}
