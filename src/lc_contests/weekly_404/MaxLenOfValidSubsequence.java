package lc_contests.weekly_404;

import java.util.Arrays;

public class MaxLenOfValidSubsequence {
    public static int maximumLength(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        dp[1] = 2;
        int temp = computeMaxLen(1, nums[0], nums[0], dp, nums);
        return temp;
    }

    public static int computeMaxLen(int index, long lastNum, long sum, int[] dp, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // not pick
        int notPick = computeMaxLen(index + 1, lastNum, sum, dp, nums);
        int pick = 0;

        if (sum % 2 != 0) {
            // odd
            if ((nums[index] + lastNum) % 2 != 0) {
                pick = computeMaxLen(index + 1, nums[index], nums[index] + lastNum, dp, nums) + 1;
            }
        } else {
            if ((nums[index] + lastNum) % 2 == 0) {
                pick = computeMaxLen(index + 1, nums[index], nums[index] + lastNum, dp, nums) + 1;
            }
        }

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    public static void main(String[] args) {
        int[] ut1 = {1, 2, 1, 1, 2, 1, 2};
        System.out.println(maximumLength(ut1));
    }
}
