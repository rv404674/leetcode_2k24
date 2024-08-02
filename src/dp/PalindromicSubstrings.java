package dp;

// TC - O(N^2)
// SC - O(N^2)
// Brute - O(N^3)
class PalindromicSubstringsSolutions {
    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int ans = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        // You are almost correct. But you need to start filling inwards and then go outwards
        // Fill small lenght first and then move on.
        // Dry run on "aaaaa"
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }

        }

        return ans;
    }
}

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstringsSolutions solution = new PalindromicSubstringsSolutions();
        System.out.println(solution.countSubstrings("aaaaa"));
    }
}
