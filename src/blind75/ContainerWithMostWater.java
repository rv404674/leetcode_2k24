package blind75;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mxArea = Integer.MIN_VALUE;

        while (left <= right) {
            int curArea = (right - left) * Math.min(height[left], height[right]);
            mxArea = Math.max(curArea, mxArea);

            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return mxArea;
    }

    public static void main(String[] args) {
        int[] ut1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(ut1));

        int[] ut2 = {1, 1};
        System.out.println(maxArea(ut2));

    }
}
