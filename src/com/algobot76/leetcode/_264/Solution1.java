package com.algobot76.leetcode._264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution1 {
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        pq.offer((long) 1);
        Set<Long> visited = new HashSet<>();
        visited.add((long) 1);

        int[] factors = new int[]{2, 3, 5};

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = pq.poll();
            for (int factor : factors) {
                long num = res * factor;
                if (!visited.contains(num)) {
                    visited.add(num);
                    pq.offer(num);
                }
            }
        }
        return (int) res;
    }
}
