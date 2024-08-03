package Adhoc;

import java.util.ArrayList;
import java.util.List;

public class DiffBetweenTwoStrings {
    // https://www.tryexponent.com/practice/prepare/difference-between-two-strings
    static String[] diffBetweenTwoStrings(String source, String target) {
        List<String> ans = new ArrayList();
        List<String>[][] dp = new List[source.length()][target.length()];
        ans = computeDiff(0, 0, source, target, dp);

        String[] finalAns = new String[ans.size()];
        int i = 0;
        for (String s : ans) {
            finalAns[i++] = s;
        }

        return finalAns;
    }

    static List<String> computeDiff(int i, int j, String source, String target, List<String>[][] dp) {
        if (i == source.length()) {
            // i reached at the end
            // add all chars of source
            List<String> temp = new ArrayList();
            for (int k = j; k < target.length(); k++) {
                temp.add("+" + target.charAt(k));
            }

            return temp;
        }

        if (j == target.length()) {
            // i reached at the end
            // add all chars of source
            List<String> temp = new ArrayList();
            for (int k = i; k < source.length(); k++) {
                temp.add("-" + source.charAt(k));
            }

            return temp;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        List<String> ans = new ArrayList();
        // if matching
        if (source.charAt(i) == target.charAt(j)) {
            ans.add(String.valueOf(source.charAt(i)));
            ans.addAll(computeDiff(i + 1, j + 1, source, target, dp));
        } else {
            // subtract from source
            List<String> temp1 = new ArrayList<>();
            temp1.add("-" + source.charAt(i));
            temp1.addAll(computeDiff(i + 1, j, source, target, dp));

            List<String> temp2 = new ArrayList<>();
            temp2.add("+" + target.charAt(j));
            temp2.addAll(computeDiff(i, j + 1, source, target, dp));

            if (temp1.size() == temp2.size()) {
                ans = temp1;
            } else {
                ans = temp1;
                if (temp2.size() < temp1.size()) {
                    ans = temp2;
                }
            }

        }

        dp[i][j] = ans;
        return dp[i][j];
    }

    public static void main(String[] args) {
        // debug your code below
        String source = "ABCDEFG";
        String target = "ABDFFGH";
        String[] result = diffBetweenTwoStrings(source, target);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}