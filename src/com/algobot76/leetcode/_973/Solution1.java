package com.algobot76.leetcode._973;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return null;
        }

        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int area1 = p1[0] * p1[0] + p1[1] * p1[1];
            int area2 = p2[0] * p2[0] + p2[1] * p2[1];
            return area2 - area1;
        });
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
