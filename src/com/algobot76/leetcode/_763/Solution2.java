package com.algobot76.leetcode._763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastIndices = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            lastIndices.put(S.charAt(i), i);
        }

        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, S.lastIndexOf(S.charAt(i)));
            if (i == right) {
                ans.add(right - left + 1);
                left = right + 1;
            }
        }
        return ans;
    }
}
