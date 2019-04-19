package com.algobot76.leetcode._681;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DFS
 */
public class Solution2 {
    private int diff = Integer.MAX_VALUE;
    private String ans = "";

    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));

        if (set.size() == 1) {
            return time;
        }
        List<Integer> digits = new ArrayList<>(set);
        int min = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        dfs(digits, "", 0, min);

        return ans;
    }

    private void dfs(List<Integer> digits, String curr, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(curr.substring(0, 2)) * 60 + Integer.parseInt(curr.substring(2, 4));
            if (m == target) {
                return;
            }
            int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                diff = d;
                ans = curr.substring(0, 2) + ":" + curr.substring(2, 4);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) {
                continue;
            }
            if (pos == 1 && Integer.parseInt(curr) * 10 + digits.get(i) > 23) {
                continue;
            }
            if (pos == 2 && digits.get(i) > 5) {
                continue;
            }
            if (pos == 3 && Integer.parseInt(curr.substring(2)) * 10 + digits.get(i) > 59) {
                continue;
            }
            dfs(digits, curr + digits.get(i), pos + 1, target);
        }
    }
}
