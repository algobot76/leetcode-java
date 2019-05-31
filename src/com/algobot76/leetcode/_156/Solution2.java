package com.algobot76.leetcode._156;

import com.algobot76.leetcode.util.TreeNode;

/**
 * DFS (Bottom-Up)
 */
public class Solution2 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfsButtonUp(root, null);
    }

    private TreeNode dfsButtonUp(TreeNode p, TreeNode parent) {
        if (p == null) {
            return parent;
        }

        TreeNode root = dfsButtonUp(p.left, p);
        p.left = (parent == null) ? parent : parent.right;
        p.right = parent;

        return root;
    }
}
