package hashtable;

import java.util.HashMap;

/**
 * Quite Difficult to develop intuition, if you have not solved it prior to this.
 * See striver video
 * Optimized - Hash Table + prefix sum.
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // key = element, value = freq
        hashMap.put(0, 1);
        int cnt = 0;
        int prefixSum = 0;

        for(int i:nums){
            prefixSum += i;
            if(hashMap.containsKey(prefixSum - k)){
                cnt += hashMap.get(prefixSum-k);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum,0) +1);
        }

        return cnt;
    }
}
