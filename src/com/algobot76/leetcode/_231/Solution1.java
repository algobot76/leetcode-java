package com.algobot76.leetcode._231;

/**
 * Bit Manipulation
 */
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
