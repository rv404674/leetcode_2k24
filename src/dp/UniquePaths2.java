package dp;

import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfsWithDp(0, 0, rows, cols, dp, obstacleGrid);
    }

    public int dfsWithDp(int i, int j, int rows, int cols, int[][] dp, int[][] obstacleGrid) {
        if (i == rows - 1 && j == cols - 1 && obstacleGrid[i][j] != 1) {
            return 1;
        }

        if (i < 0 || i >= rows || j < 0 || j >= cols || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int moveRight = dfsWithDp(i, j + 1, rows, cols, dp, obstacleGrid);
        int moveDown = dfsWithDp(i + 1, j, rows, cols, dp, obstacleGrid);

        dp[i][j] = moveRight + moveDown;
        return dp[i][j];
    }
}
