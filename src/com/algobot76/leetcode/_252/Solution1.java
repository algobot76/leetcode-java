package com.algobot76.leetcode._252;

import com.algobot76.leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(l -> l.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
