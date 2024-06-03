package blind75;

public class NumberOfIslands {
    public static void dfs(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
        visited[i][j] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];

            if (xx < row && xx >= 0 && yy < col && yy >= 0 && grid[xx][yy] == '1' && !visited[xx][yy]) {
                dfs(grid, visited, xx, yy, row, col);
            }
        }

    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    dfs(grid, visited, i, j, row, col);
                }
            }

        return cnt;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println(numIslands(grid));

    }

}
