package dp;

import java.util.Arrays;

// NOTE:
// In dp problems, donot pass the answer in the function param.
// That never works.
// need to return from the function param.
// Make a recursion tree, and do a dry run.

public class JumpGame2 {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recurse(0, dp, nums);
    }

    public static int recurse(int index, int[] dp, int[] nums) {
        if (index == nums.length - 1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minSteps = (int) 1e6;
        int maxIndexThatCanBeReached = Math.min(index + nums[index], nums.length - 1);
        for (int i = index + 1; i <= maxIndexThatCanBeReached; i++) {
            minSteps = Math.min(minSteps, recurse(i, dp, nums) + 1);
        }

        dp[index] = minSteps;
        return minSteps;
    }

    public static void main(String[] args) {
        int[] ut1 = {3, 2, 1, 0, 4};
        System.out.println(jump(ut1));
    }


}
