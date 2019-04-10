/**
 * 322. Coin Change
 *
 * @author Kaitian Xie
 */
public class CoinChange {
    // Dynamic Programming (Top Down)
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] dp) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (dp[rem - 1] != 0) {
            return dp[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, dp);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return dp[rem - 1];
    }
}
