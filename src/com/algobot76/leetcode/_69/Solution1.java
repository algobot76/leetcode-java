package com.algobot76.leetcode._69;

/**
 * Brute Force (Multiplication)
 */
public class Solution1 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        for (long s = 1; s <= x; s++) {
            if (s * s > x) {
                return (int) s - 1;
            }
        }
        return -1;
    }
}
