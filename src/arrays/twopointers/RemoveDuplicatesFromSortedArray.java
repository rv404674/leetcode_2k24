package arrays.twopointers;

class Solution {
    public int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = lo;

        while (hi < nums.length) {
            if (nums[hi] != nums[lo]) {
                lo++;
                nums[lo] = nums[hi];
            }

            hi++;
        }

        return lo + 1;
    }
}

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }
}
