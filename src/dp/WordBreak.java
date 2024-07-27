package dp;


// Good Problem asked to me in salesforce.
// DP - difficult to figoure out intention.
// Eg
// rxhul
// These can be the cases.
// (r, xhul), (rx, hul), (rxh, ul), (rxhu, l)
// After solving the first state (r, xhul) you would have computed the downstream ones as well -> hence overlapping problems.

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreakSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>(wordDict);
        // NOTE: its Boolean. not boolean.
        // by default value would be null
        Boolean[] dp = new Boolean[s.length() + 1];
        return recurse(0, s, wordDict, hashSet, dp);
    }

    // dp[0:i] = true if s[0:i] exists
    public boolean recurse(int start, String s, List<String> wordDict, Set<String> hashSet, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        // Dry run once
        // i shoudl be i<s.length()
        for (int i = start; i < s.length() + 1; i++) {
            String tempString = s.substring(start, i);
            if (hashSet.contains(tempString) && recurse(i, s, wordDict, hashSet, dp)) {
                dp[start] = true;
                return true;
            }
        }

        dp[start] = false;
        return dp[start];
    }
}

class WordBreak {
    public static void main(String[] args) {
        WordBreakSolution solution = new WordBreakSolution();
        String s1 = "leetcode";
        List<String> ut1 = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s1, ut1));

    }
}
