package codechef.contest.starters141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RedundantArray {

    // TC - O(N)
    public static long computeMinCost(int[] array) {
        long mnCost = Long.MAX_VALUE;
        int n = array.length;

        if (n == 1) {
            return 0;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : array) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            long cost = (n - entry.getValue()) * (long) entry.getKey();
            mnCost = Math.min(mnCost, cost);
        }

        return mnCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            long cost = N;

            String[] arrayStr = reader.readLine().trim().split(" ");

            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(arrayStr[i]);
            }

            System.out.println(computeMinCost(array));
        }


    }
}
