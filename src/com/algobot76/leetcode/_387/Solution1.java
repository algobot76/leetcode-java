package com.algobot76.leetcode._387;

public class Solution1 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] == 1) {
                return s.indexOf(ch);
            }
        }

        return -1;
    }
}
