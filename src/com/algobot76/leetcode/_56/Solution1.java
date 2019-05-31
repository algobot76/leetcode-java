package com.algobot76.leetcode._56;

import com.algobot76.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting
 */
public class Solution1 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> ans = new ArrayList<>();

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= last.end) {
                last.end = Math.max(curr.end, last.end);
            } else {
                ans.add(last);
                last = curr;
            }
        }
        ans.add(last);

        return ans;
    }
}
