package com.algobot76.leetcode._409;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch: s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        int remove = set.size();
        if (remove > 0) {
            remove--;
        }

        return s.length() - remove;
    }
}
