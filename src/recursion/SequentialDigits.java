package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// if the last digit is x, next would be x+1.
// DFS/Recursion wont make sense here as you just need to add +1.
// Do BFS
// By default sorted output.

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < 9; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num >= low && num <= high) {
                ans.add(num);
            }

            int lastDigit = num % 10;

            if (lastDigit < 9) {
                int nextNum = num * 10 + lastDigit + 1;
                if (nextNum <= high) {
                    q.offer(nextNum);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }
}
