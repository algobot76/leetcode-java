import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * @author Kaitian Xie
 */
public class CoinChange {
    // Dynamic Programming (Top Down)
//    public int coinChange(int[] coins, int amount) {
//        if (amount < 1) {
//            return 0;
//        }
//
//        return coinChange(coins, amount, new int[amount]);
//    }
//
//    private int coinChange(int[] coins, int rem, int[] dp) {
//        if (rem < 0) {
//            return -1;
//        }
//        if (rem == 0) {
//            return 0;
//        }
//        if (dp[rem - 1] != 0) {
//            return dp[rem - 1];
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = coinChange(coins, rem - coin, dp);
//            if (res >= 0 && res < min) {
//                min = 1 + res;
//            }
//        }
//        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//
//        return dp[rem - 1];
//    }

    // Dynamic Programming (Bottom Up)
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
