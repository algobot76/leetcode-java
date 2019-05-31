package com.algobot76.leetcode._746;

/**
 * Dynamic Programming
 */
public class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;
        int f2 = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }

        return Math.min(f1, f2);
    }
}
