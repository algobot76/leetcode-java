package com.algobot76.leetcode._322;

import java.util.Arrays;

/**
 * Dynamic Programming (Bottom Up)
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
