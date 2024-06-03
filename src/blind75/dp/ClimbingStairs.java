package blind75.dp;

import java.util.Arrays;

public class ClimbingStairs {
    // TC - O(N)
    // SC - O(N) + O(N)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return computeAns(n, dp);
    }

    public static int computeAns(int n, int[] dp) {
        if (n <= 1)
            return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = computeAns(n - 1, dp) + computeAns(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
