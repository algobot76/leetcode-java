package com.algobot76.leetcode._253;

import com.algobot76.leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Priority Queue
 */
public class Solution1 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(l -> l.start));
        allocator.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i].end);
        }

        return allocator.size();
    }
}
