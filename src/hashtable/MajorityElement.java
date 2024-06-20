package hashtable;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int mxCount = -1;
        int ans = -1;

        for (int num : nums) {
            int curValue = hashMap.getOrDefault(num, 0);
            hashMap.put(num, curValue + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > mxCount) {
                mxCount = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;

    }
}