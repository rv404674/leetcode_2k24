package binarysearch;

// Asked by harness
// Solved it.
// Intuition - Gut feeling was saying, binary search
// it was a range, and if we got the answer we can check for a lower number. That should do it.
// Got confused between dp, sorting, bs. Take two minutes and try to identify the pattern.
// Optimized = N*log(N)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int hi = -1;
        for (int bloom : bloomDay) {
            hi = Math.max(hi, bloom);
        }

        int ans = -1;
        int lo = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (getBouquets(mid, k, bloomDay) >= m) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public int getBouquets(int day, int k, int[] bloomDay) {
        int totalBouquets = 0;
        int curK = 0;
        int i = 0;


        while (i < bloomDay.length) {
            if (bloomDay[i] <= day) {
                curK++;
            } else {
                curK = 0;
            }

            if (curK == k) {
                totalBouquets++;
                curK = 0;
            }

            i++;
        }

        return totalBouquets;
    }

}

public class MinNumOfDaytoMakeMBouquets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ut1 = {5, 10, 1, 5, 20, 1, 3, 4, 5};
        System.out.println(solution.minDays(ut1, 3, 2));

        int[] ut2 = {1, 10, 3, 10, 2};
        System.out.println(solution.minDays(ut2, 3, 1));

    }

}
