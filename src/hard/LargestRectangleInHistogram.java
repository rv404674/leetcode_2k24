package hard;

// Perfect problem.
// Best Explanation - https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28902/5ms-o-n-java-solution-explained-beats-96
// Read all the comments to understand the flow properly.
// Revise the notebook as well.

// Intuition - Not a stack based solution.
// height[i] * (l-r-1)

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];

        maxFromLeft[0] = -1;
        maxFromRight[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int l = i - 1;

            while (l >= 0 && heights[l] >= heights[i])
                l = maxFromLeft[l];
            maxFromLeft[i] = l;
        }

        for (int i = n - 2; i >= 0; i--) {
            int r = i + 1;

            while (r < n && heights[r] >= heights[i])
                r = maxFromRight[r];
            maxFromRight[i] = r;
        }

        for (int i = 0; i < n; i++) {
            area = Math.max(area,
                    heights[i] * (maxFromRight[i] - maxFromLeft[i] - 1));
        }

        return area;
    }

}
