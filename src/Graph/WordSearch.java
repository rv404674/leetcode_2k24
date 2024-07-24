package Graph;

class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        int rows = board.length;
        int cols = board[0].length;

        // by default false.
        boolean[][] visited = new boolean[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (dfs(i, j, index, rows, cols, word, board, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /***
     * NOTE:
     */
    public boolean dfs(int i, int j, int index, int rows, int cols, String word, char[][] board, boolean[][] visited) {
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        if (word.charAt(index) == board[i][j]) {

            visited[i][j] = true;
            if (index == word.length() - 1) {
                return true;
            }

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && visited[x][y] == false) {
                    if (dfs(x, y, index + 1, rows, cols, word, board, visited)) {
                        return true;
                    }
                }
            }

        }

        // if the word doesnt match return false.
        visited[i][j] = false;
        return false;
    }

    // Note: A cell that has been already visited and failed, can be a part of another successfull word hit.
    public boolean dfsEasyVersion(int i, int j, int index, String word, char[][] board, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == false) {
            return false;
        }

        visited[i][j] = true;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (dfsEasyVersion(x, y, index + 1, word, board, visited)) {
                return true;
            }
        }

        // reset it.
        visited[i][j] = false;
        return false;
    }

}

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        Solution solution = new Solution();
        System.out.println(solution.exist(board, "AAB"));

    }
}
