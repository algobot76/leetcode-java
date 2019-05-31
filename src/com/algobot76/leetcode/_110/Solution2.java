package com.algobot76.leetcode._110;

import com.algobot76.leetcode.util.TreeNode;

/**
 * Recursion (Bottom-Up)
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = maxDepth(root.right);
        if (right == -1) {
            return -1;
        }

        return (Math.abs(left - right) <= 1) ? (Math.max(left, right) + 1) : -1;
    }
}

