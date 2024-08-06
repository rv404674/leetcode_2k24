package Graph;


class MaxAreaOfIslandSolution {
    public int maxAreaOfIsland(int[][] grid) {
        int mxArea = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    mxArea = Math.max(
                            mxArea,
                            dfs(i, j, n, m, visited, grid)
                    );
                }
            }
        }

        return mxArea;
    }

    public int dfs(int i, int j, int n, int m, boolean[][] visited, int[][] grid) {
        int mxArea = 1;
        visited[i][j] = true;

        int[][] directions = {
                {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };

        for (int[] direction : directions) {
            int xx = direction[0] + i;
            int yy = direction[1] + j;

            if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] == 1 && !visited[xx][yy]) {
                mxArea += dfs(xx, yy, n, m, visited, grid);
            }
        }

        return mxArea;
    }
}


public class MaxAreaOfIsland {
    public static void main(String[] args) {

    }
}
