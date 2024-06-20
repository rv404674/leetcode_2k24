package blind75.dp;

import java.util.Arrays;

public class CoinChange {
    // TC -  * O(amount * coins.len)
    // SC - O(amount) + O(amount)
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        compute(amount, coins, dp);

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];

    }

    public static int compute(int amount, int[] coins, int[] dp) {
        if (amount <= 0)
            return 0;

        if (dp[amount] != -1)
            return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                minCoins = Math.min(minCoins, compute(amount - coins[i], coins, dp));
            }
        }

        if (minCoins == Integer.MAX_VALUE)
            dp[amount] = Integer.MAX_VALUE;
        else {
            dp[amount] = minCoins + 1;
        }


        return dp[amount];
    }

    public static int coinChangeUsingTabulation(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins)
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] ut1 = {2, 3, 4, 7, 10};
        int amount = 24;
        System.out.println(coinChangeUsingTabulation(ut1, amount));

        int[] ut2 = {5, 6, 7};
        amount = 3;
        System.out.println(coinChangeUsingTabulation(ut2, amount));

    }
}
