package com.algobot76.leetcode._98;

import com.algobot76.leetcode.util.TreeNode;

/**
 * Brute Force
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSubtreeLessThan(root.left, root.val) && isSubtreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isSubtreeLessThan(TreeNode p, int val) {
        if (p == null) {
            return true;
        }
        return p.val < val && isSubtreeLessThan(p.left, val) && isSubtreeLessThan(p.right, val);
    }

    private boolean isSubtreeGreaterThan(TreeNode p, int val) {
        if (p == null) {
            return true;
        }
        return p.val > val && isSubtreeGreaterThan(p.left, val) && isSubtreeGreaterThan(p.right, val);
    }
}
