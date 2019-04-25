package com.algobot76.leetcode._69;

/**
 * Newton’s Method
 */
public class Solution4 {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x)
            n = (n + x / n) / 2;
        return (int)n;
    }
}
