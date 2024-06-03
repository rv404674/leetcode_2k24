package blind75;

public class MissingNumber {
    // Aprroach 1 -
    // Use Hashmap
    // TC - 2*O(N), SC - O(N)

    // Approach 2
    // Sum of all the elemnts
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (Integer i : nums) {
            sum += i;
        }

        int ans = n * (n + 1) / 2 - sum;
        return ans;
    }

    public static void main(String[] args) {
        int[] ut1 = {0, 1};
        System.out.println(missingNumber(ut1));
    }
}
