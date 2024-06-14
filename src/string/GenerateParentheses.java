package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recurse(n, 0, 0, "", ans);
        return ans;
    }

    public static void recurse(int n, int countOpen, int countClosed, String curString, List<String> ans) {
        if (curString.length() == n * 2) {
            ans.add(curString);
            return;
        }

        if (countOpen < n) {
            recurse(n, countOpen + 1, countClosed, curString + "(", ans);
        }

        if (countOpen > countClosed) {
            recurse(n, countOpen, countClosed + 1, curString + ")", ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
