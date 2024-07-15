package interviews;

public class HarnessR1 {


    public static void main(String[] args) {
        System.out.println("Hello world!");


    }

//     * m = 3, k = 2
//            * [5,10,1,20,5, 1,3,4,5]
//            *

    /**
     * You are given an integer array bloomDay, an integer m and an integer k.
     * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
     * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
     * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
     *
     * @param args Assumption - ( n = 10^5), (m,k < 10^6)
     *             each element = 10^9
     *             Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
     *             Output: 12
     *             <p>
     *             Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
     *             Output: -1
     *             <p>
     *             Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
     *             Output: 3
     *             <p>
     *             day = 5 (
     *             <p>
     *             for(i = 1; i<=10)
     *             { int mid = lo + hi /2
     *             if(isAnswer(bllomDay, mid, m, k) == true0{
     *             <p>
     *             }
     *             <p>
     *             <p>
     *             <p>
     *             m = 3, k = 2
     *             [5,10,1,20,5, 1,3,4,5]
     *             <p>
     *             <p>
     *             10 is anwer
     *             (5,10,) (5,1) (3,4)
     *             9 - NO
     *             <p>
     *             <p>
     *             <p>
     *             i = 0
     *             (5,10), (1,5), (20,1) ~= 20 (m = 0)
     *             (20,1) (3,4) .. 5 ERROR
     *             i = 1
     *             (10,1), (5,12)
     */

    public int findBloomDays(int m, int k, int[] bloomDays) {
        int n = bloomDays.length;
        int ans = -1;
        if (m * k > n) {
            return -1;
        }

        // upper limit
        int hi = -1;
        for (int day : bloomDays) {
            hi = Math.max(day, hi);
        }

        int lo = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isValidAnswer(m, k, mid, bloomDays)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        return ans;

    }

    public boolean isValidAnswer(int m, int k, int day, int[] bloomDays) {
        int ansM = 0;

        for (int i = 0; i < bloomDays.length - k; i++) {

            int j;
            for (j = i; j < i + k; j++) {
                if (bloomDays[j] > day) {
                    break;
                }
            }

            if (j == i + k) {
                ansM++;
            }

            if (ansM == m) {
                return true;
            }

        }

        return false;

    }


}