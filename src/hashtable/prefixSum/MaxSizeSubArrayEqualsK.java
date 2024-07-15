package hashtable.prefixSum;

import java.util.HashMap;

// Prefix Sum + Hashing.
// Striver - https://www.youtube.com/watch?v=frf7qxiN2qU
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // (value, index)
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ansLen = 0;
        int prefixSum = 0;
        hashMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (hashMap.containsKey(prefixSum - k)) {
                ansLen = Math.max(ansLen, i - hashMap.get(prefixSum - k));
            }

            // NOTE: we want the longest. So if an element is already added, dont add it again.
            if (!hashMap.containsKey(prefixSum)) {
                hashMap.put(prefixSum, i);
            }
        }

        return ansLen;
    }
}


public class MaxSizeSubArrayEqualsK {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ut1 = {1, -1, 5, -2, 3};
        System.out.println(solution.maxSubArrayLen(ut1, 3));

        int[] ut2 = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        System.out.println(solution.maxSubArrayLen(ut2, 3));
    }

}
