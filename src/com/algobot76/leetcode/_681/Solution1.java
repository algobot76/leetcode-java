package com.algobot76.leetcode._681;

/**
 * Brute Force
 */
public class Solution1 {
    public String nextClosestTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        while (true) {
            if (++min == 60) {
                min = 0;
                hour++;
                hour %= 24;
            }
            String curr = String.format("%02d:%02d", hour, min);
            if (isValid(time, curr)) {
                return curr;
            }
        }
    }

    private boolean isValid(String time, String curr) {
        for (int i = 0; i < curr.length(); i++) {
            if (time.indexOf(curr.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
