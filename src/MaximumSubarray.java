import java.util.Arrays;
import java.util.Collections;

public class MaximumSubarray {
    // Dynamic Programming
    public int maxSubArray(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        return Collections.max(Arrays.asList(dp));
    }
}
