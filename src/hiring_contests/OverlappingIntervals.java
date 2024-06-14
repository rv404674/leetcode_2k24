package hiring_contests;

import java.util.Scanner;

public class OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] input = line.split(" ");
        int[] interval1 = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        int[] interval2 = {Integer.parseInt(input[2]), Integer.parseInt(input[3])};

        if (interval1[1] > interval2[0]) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}
