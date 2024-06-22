package dp;

import java.util.Arrays;

public class BestTimetoBuyAndSellStock2 {
    // DP - Striver Video
    // Intuition - To buy or sell, we need to know, whether a stock has been already bought or not.
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // while starting, you can buy.
        return recurse(0, 1, prices, dp);
    }


    public static int recurse(int index, int buy, int[] prices, int[][] dp) {
        int profit = 0;

        if (index == prices.length) {
            return profit;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        // if buy is 1
        if (buy == 1) {
            profit = Math.max(
                    // buy now,
                    // profit = +sp - cp
                    // cp would be subtracted.
                    -prices[index] + recurse(index + 1, 0, prices, dp),
                    0 + recurse(index + 1, 1, prices, dp)
            );
        } else {
            profit = Math.max(
                    // sell now
                    prices[index] + recurse(index + 1, 1, prices, dp),
                    0 + recurse(index + 1, 0, prices, dp)
            );
        }

        dp[index][buy] = profit;
        return dp[index][buy];
    }

    public static void main(String[] args) {
        int[] ut1 = {1, 12, 25, 30, 9};
        System.out.println(maxProfit(ut1));

        int[] ut2 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ut2));
    }

}
