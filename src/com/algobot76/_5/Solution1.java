package com.algobot76._5;

/**
 * Brute Force
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
            left = i;
            right = i + 1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
        }

        return s.substring(start, end + 1);
    }
}
