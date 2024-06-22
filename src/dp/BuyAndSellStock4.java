package dp;


// FIXME: Ask chatgpt,
// there is something missing here.
public class BuyAndSellStock4 {
    public static int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        // fill this matrix
        for (int i = 0; i < prices.length; i++)
            for (int j = 0; j < 2; j++)
                for (int x = 0; x < k; x++)
                    dp[i][j][x] = -1;

        // while starting, you can buy.
        return recurse(0, 1, k, prices, dp);
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
        int[] ut1 = {3, 2, 6, 5, 0, 3};
        int k = 2;

        System.out.println(maxProfit(k, ut1));
    }
}
