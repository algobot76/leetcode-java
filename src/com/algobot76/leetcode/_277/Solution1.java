package com.algobot76.leetcode._277;

import com.algobot76.leetcode.util.Relation;

public class Solution1 extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (knows(ans, i)) {
                ans = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans != i && knows(ans, i)) {
                return -1;
            }
            if (ans != i && !knows(i, ans)) {
                return -1;
            }
        }

        return ans;
    }
}
