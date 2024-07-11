package Graph;


import java.util.LinkedList;
import java.util.Queue;

class Orange {
    int x;
    int y;

    public Orange(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalOnes = 0;


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Orange> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 2) {
                    queue.offer(new Orange(i, j));
                } else if (grid[i][j] == 1) {
                    totalOnes++;
                }
        }


        while (!queue.isEmpty()) {
            int curLen = queue.size();
            for (int i = 1; i <= curLen; i++) {
                Orange orange = queue.poll();

                // move in four directions
                for (int k = 0; k < 4; k++) {
                    int xx = orange.x + dx[k];
                    int yy = orange.y + dy[k];

                    if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        totalOnes--;
                        queue.offer(new Orange(xx, yy));
                    }
                }
            }

            time++;
        }

        // check for a -1.
        if (totalOnes != 0) {
            return -1;
        }

        return Math.max(0, time - 1);
    }

    public static void main(String[] args) {
        int[][] ut1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(ut1));
    }


}
