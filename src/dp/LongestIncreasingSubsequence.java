package dp;

import java.util.Arrays;

/**
 * Really difficult to built intuition.
 * Striver Video - https://www.youtube.com/watch?v=IFfYfonAFGc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=43
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // i -> (0 - n-1), prevIndex -> (-1 -> n-1)
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return recurse(0, -1, nums, dp);
    }

    public int recurse(int i, int prevIndex, int[] nums, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prevIndex + 1] != -1) {
            return dp[i][prevIndex + 1];
        }

        // not pick
        dp[i][prevIndex + 1] = recurse(i + 1, prevIndex, nums, dp);

        // pick
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            dp[i][prevIndex + 1] = Math.max(dp[i][prevIndex + 1], 1 + recurse(i + 1, i, nums, dp));
        }

        return dp[i][prevIndex + 1];
    }

}
