package com.algobot76.leetcode._69;

/**
 * Brute Force (Division)
 */
public class Solution2 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        for (int s = 1; s <= x; s++) {
            if (s > x / s) {
                return s - 1;
            }
        }
        return -1;
    }
}
