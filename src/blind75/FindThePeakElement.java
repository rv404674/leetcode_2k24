package blind75;

public class FindThePeakElement {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (nums.length == 1)
            return 0;

        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int lo = 1;
        int hi = n - 2;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            // striver peak graph
            if (nums[mid] > nums[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] ut1 = {1, 2, 1, 2, 1};
        System.out.println(findPeakElement(ut1));
    }
}
