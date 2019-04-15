package com.algobot76.leetcode._156;

import com.algobot76.leetcode.util.TreeNode;

/**
 * Iteration (Top-Down)
 */
public class Solution1 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode p = root;
        TreeNode parent = null;
        TreeNode parentRight = null;

        while (p != null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }

        return parent;
    }
}
