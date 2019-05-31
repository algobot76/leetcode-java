package com.algobot76.leetcode._104;

import com.algobot76.leetcode.util.TreeNode;

public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
