package com.algobot76.leetcode._295;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Two Heaps
 */
public class MedianFinder1 {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder1() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}