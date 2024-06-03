package hard;

// Intuition - Find the largest area of histogram.
// TC - 2*O(R*C)
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] heights = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else {
                    if (i - 1 >= 0) {
                        heights[i][j] = heights[i - 1][j] + 1;
                    } else {
                        heights[i][j] = 1;
                    }
                }
            }
        }

        int mxArea = -1;
        for (int i = 0; i < r; i++)
            mxArea = Math.max(mxArea, largestAreaOfHistogram(heights[i]));

        return mxArea;
    }

    public static int largestAreaOfHistogram(int[] heights) {
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

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '1'},
                {'1', '1', '1'}
        };

        System.out.println(maximalRectangle(matrix));
    }


}
