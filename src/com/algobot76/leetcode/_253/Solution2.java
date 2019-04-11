package com.algobot76.leetcode._253;

import com.algobot76.leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Chronological Ordering
 */
public class Solution2 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start, Comparator.comparingInt(a -> a));
        Arrays.sort(end, Comparator.comparingInt(a -> a));

        int startPtr = 0;
        int endPtr = 0;
        int rooms = 0;

        while (startPtr < intervals.length) {
            if (start[startPtr] >= end[endPtr]) {
                rooms -= 1;
                endPtr += 1;
            }
            rooms += 1;
            startPtr += 1;
        }

        return rooms;
    }
}
