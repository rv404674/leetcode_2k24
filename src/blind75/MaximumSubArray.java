package blind75;

/**
 * Brute - O(N2)
 * Intuition - We wont carry forward a negative sum, drop a negative sum.
 */
public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int mx = nums[0];
        int sum = 0;

        for (Integer num : nums) {
            sum += num;
            mx = Math.max(sum, mx);

            if (sum < 0) {
                sum = 0;
            }
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] ut1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(ut1));

        int[] ut2 = {5, 2, -1, -5, 10, 1, -2, 20, 3};
        System.out.println(maxSubArray(ut2));
    }
}
