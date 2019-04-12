package com.algobot76.leetcode._438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sliding Window
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return ans;
        }

        int m = p.length();
        int n = s.length();
        int[] pa = new int[26];
        int[] sa = new int[26];

        for (char ch : p.toCharArray()) {
            pa[(int) ch - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (i >= p.length()) {
                sa[(int) s.charAt(i - m) - 'a']--;
            }
            sa[(int) s.charAt(i) - 'a']++;
            if (Arrays.equals(sa, pa)) {
                ans.add(i + 1 - m);
            }
        }

        return ans;
    }
}
