package hashtable;

import java.util.HashMap;

// NOTE: check neetcode's solution.
// Prefix sum (need to work on this).
// Dry run
// [0,0,1,1,0,1,1]
// [1, 0, 1, 0,1,1]
public class ContiguousSubArray {
    public int findMaxLength(int[] nums) {
        // (key, val) -> (diff, index)
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = -1;
        int zeroes = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                ones++;
            }

            int diff = ones - zeroes;
            // just put the first occurence. We want to remove the min subarray.
            if (!hm.containsKey(diff)) {
                hm.put(diff, i);
            }

            if (ones == zeroes) {
                res = Math.max(res, ones + zeroes);
            } else {
                res = Math.max(res, i - hm.get(diff));
            }
        }

        return res;
    }
}
