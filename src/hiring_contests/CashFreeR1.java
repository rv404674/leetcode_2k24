package hiring_contests;

import java.util.List;


class Result {

    public static int findMinimumShifts(List<String> mat) {
        // Write your code here
        int row = mat.size();
        int col = mat.get(0).length();

        int[][] shiftGrid = new int[row][col];
        int ans = Integer.MAX_VALUE;

        for (int p = 0; p < mat.size(); p++) {
            String s = mat.get(p);

            int[] moveToRight = new int[col];
            int[] moveToLeft = new int[col];

            // 0 0 0 1
            // mvoeTORigt
            //

            // fill moveToRight
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '1') {
                    moveToRight[i] = i;
                } else if (c == '0' && i != 0) {
                    moveToRight[i] = moveToRight[i - 1];
                } else {
                    moveToRight[i] = Integer.MAX_VALUE;
                }
            }

            // fill moveToLeft
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);

                if (c == '1') {
                    moveToLeft[i] = i;
                } else if (c == '0' && i != s.length() - 1) {
                    moveToLeft[i] = moveToLeft[i + 1];
                } else {
                    moveToLeft[i] = Integer.MAX_VALUE;
                }
            }

            // fill grid matrix
            boolean ansExist = false;
            for (int x = 0; x < s.length(); x++) {
                shiftGrid[p][x] = Math.min(moveToLeft[x], moveToRight[x]);

                if (shiftGrid[p][x] != Integer.MAX_VALUE) {
                    ansExist = true;
                }
            }

            if (!ansExist) {
                return -1;
            }
        }


        for (int i = 0; i < col; i++) {
            int temp = 0;
            for (int j = 0; j < row; j++) {
                temp += Math.abs(i - shiftGrid[j][i]);
            }

            ans = Math.min(ans, temp);
        }

        return ans;

    }

}

public class CashFreeR1 {
}
