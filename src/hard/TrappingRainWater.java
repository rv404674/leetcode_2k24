package hard;

public class TrappingRainWater {
    // BruteForce - O(N^N)
    // App1 - left Array, right Array
    // TC - 3*O(N)

    // App2 - left array, traverse from the right
    // TC - O(2*N)

    //
    // TC - O(N)
    // SC - O(1)
    public static int trap(int[] height) {
        if (height.length <= 2)
            return 0;

        int totalWater = 0;
        int n = height.length;
        int lo = 0;
        int hi = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];

        while (lo < hi) {
            leftMax = Math.max(leftMax, height[lo]);
            rightMax = Math.max(rightMax, height[hi]);

            // Crux formula is ans = Min(leftMax, rightMax) - height[current];
            // Our bottleneck is the min one. Hence try moving the smaller one.
            // also since we are always doing Math.max, moving left to right, will give us a bigger one.
            if (leftMax <= rightMax) {
                totalWater += leftMax - height[lo];
                lo++;
            } else {
                totalWater += rightMax - height[hi];
                hi--;
            }

        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] ut1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(ut1));

        int[] ut2 = {5, 5};
        System.out.println(trap(ut2));
    }
}
