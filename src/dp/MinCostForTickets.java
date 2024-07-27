package dp;

import java.util.Arrays;
import java.util.HashSet;

// TC - O(N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> presentDays = new HashSet<>();
        int mxDay = days[days.length - 1];

        int[] dp = new int[mxDay + 1];
        Arrays.fill(dp, -1);

        for (int day : days) {
            presentDays.add(day);
        }

        int x = compute(1, mxDay, days, costs, dp, presentDays);
        return x;
    }

    public int compute(int day, int mxDay, int[] days, int[] costs, int[] dp, HashSet<Integer> presentDays) {
        if (day > mxDay) {
            return 0;
        }

        if (dp[day] != -1) {
            return dp[day];
        }

        int cost = Integer.MAX_VALUE;
        if (!presentDays.contains(day)) {
            // do not compute for this day, as we wont be travelling for this day. skip it.
            return compute(day + 1, mxDay, days, costs, dp, presentDays);
        } else {
            int costFor1DayPass = compute(day + 1, mxDay, days, costs, dp, presentDays) + costs[0];
            int costFor7DayPass = compute(day + 7, mxDay, days, costs, dp, presentDays) + costs[1];
            int costFor30DayPass = compute(day + 30, mxDay, days, costs, dp, presentDays) + costs[2];

            cost = Math.min(costFor1DayPass, Math.min(costFor7DayPass, costFor30DayPass));
        }

        dp[day] = cost;
        return cost;
    }


}

public class MinCostForTickets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ut1[] = {1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29};
        int costs[] = {3, 14, 50};

        System.out.println(solution.mincostTickets(ut1, costs));
    }

}
