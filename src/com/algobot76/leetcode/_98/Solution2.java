package com.algobot76.leetcode._98;

import com.algobot76.leetcode.util.TreeNode;

/**
 * Recursion (Top-Down)
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode p, Integer low, Integer high) {
        if (p == null) {
            return true;
        }

        return (low == null || p.val > low) && (high == null || p.val < high) && isValid(p.left, low, p.val) && isValid(p.right, p.val, high);
    }
}
