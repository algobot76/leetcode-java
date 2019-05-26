package com.algobot76.leetcode._973;

import java.util.Arrays;

/**
 * Sort
 */
public class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return null;
        }

        Arrays.sort(points, (p1, p2) -> {
            int area1 = p1[0] * p1[0] + p1[1] * p1[1];
            int area2 = p2[0] * p2[0] + p2[1] * p2[1];
            return area1 - area2;
        });
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }

        return ans;
    }
}
