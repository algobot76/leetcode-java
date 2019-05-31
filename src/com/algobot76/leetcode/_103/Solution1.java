package com.algobot76.leetcode._103;

import com.algobot76.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 */
public class Solution1 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            ans.add(newLevel);
        }
        List<Integer> currLevel = ans.get(level);
        if (level % 2 == 0) {
            currLevel.add(root.val);
        } else {
            currLevel.add(0, root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
