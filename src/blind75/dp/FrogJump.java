package blind75.dp;

import java.util.Arrays;

public class FrogJump {
    public static int minimumEnergy(int arr[], int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        compute(N - 1, arr, dp);
        return dp[N - 1];

    }

    public static int compute(int index, int[] arr, int[] dp) {
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int jumpOneStep = compute(index - 1, arr, dp) + Math.abs(arr[index] - arr[index - 1]);

        int jumpTwoStep = Integer.MAX_VALUE;
        if (index > 1) {
            jumpTwoStep = compute(index - 2, arr, dp) + Math.abs(arr[index] - arr[index - 2]);
        }

        dp[index] = Math.min(jumpOneStep, jumpTwoStep);
        return dp[index];
    }

    public static void main(String[] args) {
        int N = 8;
        int[] arr = {7, 4, 4, 2, 6, 6, 3, 4};
        //7
        System.out.println(minimumEnergy(arr, N));
    }
}
