package dp;

import java.util.Arrays;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // Use same approach as JumpGame2 -> calculate the min steps required.
        // Make a recursion tree.
        recurse(0, dp, nums);

        if (dp[0] == (int) 1e6) {
            return false;
        }

        return true;
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
        System.out.println(canJump(ut1));
    }

}
