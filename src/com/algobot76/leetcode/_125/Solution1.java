package com.algobot76.leetcode._125;


/**
 * Two Pointers
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            if (left == s.length()) {
                return true;
            }
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                break;
            } else {
                left++;
                right--;
            }
        }

        return right <= left;
    }
}
