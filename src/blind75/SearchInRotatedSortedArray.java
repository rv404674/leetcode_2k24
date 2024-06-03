package blind75;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] ut1 = {10, 12, 15, 2, 4, 7, 8};
        System.out.println(search(ut1, 10));
        System.out.println(search(ut1, 2));
        System.out.println(search(ut1, 8));
        System.out.println(search(ut1, 100));
        System.out.println(search(ut1, 1));
    }

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                return mid;
            }

            // left side is sorted.
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target <= nums[mid])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            // right side is sorted.
            else {
                if (nums[mid] <= target && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }

        }

        if (nums[lo] == target)
            return lo;

        return -1;

    }
}
