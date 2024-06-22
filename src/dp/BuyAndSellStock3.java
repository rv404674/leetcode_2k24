package dp;

public class BuyAndSellStock3 {
    // DP - Striver Video
    // Intuition - To buy or sell, we need to know, whether a stock has been already bought or not.
    public static int maxProfit(int[] prices) {
        int k = 3;

        int[][][] dp = new int[prices.length][2][k];
        // fill this matrix
        for (int i = 0; i < prices.length; i++)
            for (int j = 0; j < 2; j++)
                for (int x = 0; x < k; x++)
                    dp[i][j][x] = -1;

        // while starting, you can buy.
        return recurse(0, 1, 2, prices, dp);
    }


    public static int recurse(int index, int buy, int k, int[] prices, int[][][] dp) {
        int profit = 0;
        if (k == 0 || index == prices.length) {
            return profit;
        }

        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }

        // if buy is 1
        if (buy == 1) {
            profit = Math.max(
                    // buy now,
                    // profit = +sp - cp
                    // cp would be subtracted.
                    -prices[index] + recurse(index + 1, 0, k, prices, dp),
                    0 + recurse(index + 1, 1, k, prices, dp)
            );
        } else {
            profit = Math.max(
                    // sell now
                    prices[index] + recurse(index + 1, 1, k - 1, prices, dp),
                    0 + recurse(index + 1, 0, k, prices, dp)
            );
        }

        dp[index][buy][k] = profit;
        return dp[index][buy][k];
    }

    public static void main(String[] args) {
        int[] ut1 = {1, 12, 25, 30, 9};
        System.out.println(maxProfit(ut1));

        int[] ut2 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ut2));
    }

}


