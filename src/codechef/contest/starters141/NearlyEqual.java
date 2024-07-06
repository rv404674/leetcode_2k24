package codechef.contest.starters141;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NearlyEqual {
    public static int computeMinHammingDistance(String a, String b) {
        int ans = Integer.MAX_VALUE;
        int lenb = b.length();

        for (int i = 0; i <= a.length() - lenb; i++) {
            int end = i + lenb;
            String temp = a.substring(i, end);
            ans = Math.min(ans, hammingDistance(temp, b));
        }

        return ans;
    }

    public static int hammingDistance(String temp, String b) {
        int diff = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;

    }


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine().trim()); // Read the number of test cases

        for (int t = 0; t < T; t++) {
            String[] sizes = reader.readLine().trim().split(" ");
            int N = Integer.parseInt(sizes[0]);
            int M = Integer.parseInt(sizes[1]);

            String A = reader.readLine().trim();
            String B = reader.readLine().trim();

            // Call your computeMinHammingDistance method here and process the result
            int result = computeMinHammingDistance(A, B);
            System.out.println(result);
        }

        reader.close();

    }
}
