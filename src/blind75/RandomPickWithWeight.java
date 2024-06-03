package blind75;

import java.util.Random;

class Solution {
    int[] prefixSum;
    Random random;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++)
            prefixSum[i] = w[i] + prefixSum[i - 1];

        random = new Random();

    }

    public int pickIndex() {
        int randomNumber = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;

        // apply binary search on this random number;
        int lo = 0;
        int hi = prefixSum.length - 1;

        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (prefixSum[mid] < randomNumber) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}

public class RandomPickWithWeight {
    public static void main(String[] args) {

    }
}
