package com.algobot76.leetcode._480;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Two Heaps
 */
public class Solution1 {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<>(n);
        double[] ans = new double[n - k + 1];
        if (n == 0) {
            return ans;
        }
        int p = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            balance();
            if (i >= k) {
                if (nums[i - k] > maxHeap.peek()) {
                    minHeap.remove(nums[i - k]);
                } else {
                    maxHeap.remove(nums[i - k]);
                }
            }
            balance();
            if (i >= k - 1) {
                if (maxHeap.size() > minHeap.size()) {
                    ans[p] = maxHeap.peek();
                } else {
                    ans[p] = (((double) maxHeap.peek()) + ((double) minHeap.peek())) / 2.0;
                }
                p++;
            }
        }

        return ans;
    }

    private void balance() {
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.offer(maxHeap.poll());
        }
    }
}
