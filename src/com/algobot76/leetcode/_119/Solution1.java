package com.algobot76.leetcode._119;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<Integer> getRow(int k) {
        Integer[] ans = new Integer[k + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = i; j > 0; j--) {
                ans[j] = ans[j] + ans[j - 1];
            }
        }

        return Arrays.asList(ans);
    }
}
