package blind75;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    // Brute - O(N)
    // when you get the target, keep track of the min,max.
    public static void main(String[] args) {
        int[] ut = {1};
        System.out.println(Arrays.toString(searchRange(ut, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        // one bin search to find low
        // one bin search to find high.
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int lo = binSearchForStartIndex(nums, target);
        int hi = binSearchForEndIndex(nums, target);

        return new int[]{lo, hi};
    }

    public static int binSearchForStartIndex(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo < n && nums[lo] == target)
            return lo;
        return -1;
    }

    public static int binSearchForEndIndex(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (hi >= 0 && nums[hi] == target)
            return hi;
        return -1;
    }
}
