package blind75;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] ut1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(ut1)));

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftPrefix = new int[nums.length];
        int[] rightPrefix = new int[nums.length];
        int[] ans = new int[nums.length];
        int n = nums.length;

        leftPrefix[0] = nums[0];
        rightPrefix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            leftPrefix[i] = nums[i] * leftPrefix[i - 1];
            rightPrefix[n - i - 1] = nums[n - i - 1] * rightPrefix[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = rightPrefix[i + 1];
                continue;
            }

            if (i == n - 1) {
                ans[i] = leftPrefix[i - 1];
                continue;
            }

            ans[i] = leftPrefix[i - 1] * rightPrefix[i + 1];
        }

        return ans;
    }
}
