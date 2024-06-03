package blind75;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];

            if (hashMap.containsKey(left)) {
                return new int[]{hashMap.get(left), i};
            }

            hashMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] testCase1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(TwoSum.twoSum(testCase1, 9)));

        int[] testCase2 = {3, 2, 4};
        System.out.println(Arrays.toString(TwoSum.twoSum(testCase2, 6)));
    }
}
