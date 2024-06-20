package dp;

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return recurse(nums.length - 1, nums, dp);
    }

    public static int recurse(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return nums[i];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(
                nums[i] + recurse(i - 2, nums, dp),
                recurse(i - 1, nums, dp)
        );

        return dp[i];
    }

    public static void main(String[] args) {
        int[] ut1 = {10};
        System.out.println(rob(ut1)); // 10

        int[] ut2 = {2, 10, 20, 15, 1};
        System.out.println(rob(ut2)); // 25

    }
}
