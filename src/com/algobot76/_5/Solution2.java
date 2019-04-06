package com.algobot76._5;

/**
 * Dynamic Programming
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}
