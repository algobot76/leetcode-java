package com.algobot76.leetcode._111;

import com.algobot76.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-First Traversal
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode rightMost = root;
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            if (node == rightMost) {
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }

        return depth;
    }
}
