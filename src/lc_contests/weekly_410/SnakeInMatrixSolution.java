package lc_contests.weekly_410;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SnakeInMatrixSolution {
    public static int finalPositionOfSnake(int n, List<String> commands) {
        HashMap<String, List<Integer>> directions = new HashMap<>();
        directions.put("UP", Arrays.asList(-1, 0));
        directions.put("DOWN", Arrays.asList(1, 0));
        directions.put("RIGHT", Arrays.asList(0, 1));
        directions.put("LEFT", Arrays.asList(0, -1));

        int x = 0;
        int y = 0;
        for (String command : commands) {
            List<Integer> direction = directions.get(command);
            x += direction.get(0);
            y += direction.get(1);
        }

        return (x * n) + y;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> ut1 = Arrays.asList("RIGHT", "DOWN");
        System.out.println(SnakeInMatrixSolution.finalPositionOfSnake(n, ut1));
    }
}
