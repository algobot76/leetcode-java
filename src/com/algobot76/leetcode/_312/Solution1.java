package com.algobot76.leetcode._312;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return null;
        }

        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int a1 = this.getArea(p1);
            int a2 = this.getArea(p2);
            return a2 - a1;
        });
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    private int getArea(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
