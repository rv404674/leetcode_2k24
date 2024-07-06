package lc_contests.weekly_404;

public class MaxHeightOfTriangle {
    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(
                getHeight(red, blue),
                getHeight(blue, red)
        );
    }

    public static int getHeight(int red, int blue) {
        int height = 1;

        while (true) {
            if (height % 2 != 0) {
                // blue
                if (height > blue) break;
                blue -= height;
            } else {
                if (height > red) break;
                red -= height;
            }

            height++;
        }

        return height - 1;
    }


    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(4, 9));// 4
        System.out.println(maxHeightOfTriangle(2, 1)); // 2
        System.out.println(maxHeightOfTriangle(1, 1)); // 1
        System.out.println(maxHeightOfTriangle(10, 1)); // 2
    }
}
