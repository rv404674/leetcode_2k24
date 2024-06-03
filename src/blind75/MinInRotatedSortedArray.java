package blind75;

/**
 * Brute - O(N)
 * Most Optimized - O(logn)
 * See the algo, its quite intuitive.
 */
public class MinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] <= nums[mid]) {
                // discard this part and use the min
                ans = Math.min(nums[lo], ans);
                lo = mid + 1;
            } else {
                // right part is sorted. discard this
                ans = Math.min(nums[mid], ans);
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ut1 = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(findMin(ut1));

        int[] ut2 = {4, 5, 1, 2, 3};
        System.out.println(findMin(ut2));

        int[] ut3 = {2, 4, 5, 6, 7, 0, 1};
        System.out.println(findMin(ut3));
    }
}
