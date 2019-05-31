package com.algobot76.leetcode._121;

public class Solution1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrifit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxPrifit) {
                maxPrifit = prices[i] - minPrice;
            }
        }

        return maxPrifit;
    }
}
