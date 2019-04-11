package com.algobot76.leetcode._215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Heap
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}
