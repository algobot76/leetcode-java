package com.algobot76.leetcode._215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
