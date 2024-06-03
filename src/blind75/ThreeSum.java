package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    // HashSet Approach
    // TC - O(N^2 * logn)
    // SC - 2 * O(N)
    public static List<List<Integer>> threeSumHashMap(int[] nums) {
        HashSet<Integer> tempSet = new HashSet<>();
        HashSet<List<Integer>> ansSet = new HashSet<>();

        // NOTE: You can't again take num[i], num[j] as the third element.
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                int left = -(nums[i] + nums[j]);

                if (tempSet.contains(left)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], left);
                    temp.sort(null);
                    ansSet.add(temp);
                }

                tempSet.add(nums[j]);
            }

            tempSet.clear();

        }

        List<List<Integer>> ans = new ArrayList<>(ansSet);
        return ans;
    }

    // Two Pointer.
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // remove duplicates
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // skip the duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] ut1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ut1));

        int[] ut2 = {-1, 2, 3, -2, 4, 0, 2};
        System.out.println(threeSum(ut2));
    }
}
