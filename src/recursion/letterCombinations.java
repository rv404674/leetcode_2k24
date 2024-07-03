package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {
    private static HashMap<Integer, String> digitToLettersMap = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        // fill the hashmap
        Character currentChar = 'a';
        StringBuilder stringBuilder = new StringBuilder();
        int len;

        for (int i = 2; i <= 9; i++) {
            len = 3;
            if (i == 7 || i == 9) {
                len = 4;
            }

            for (int k = 1; k <= len; k++) {
                stringBuilder.append(currentChar);
                currentChar++;
            }
            digitToLettersMap.put(i, stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        if (digits.length() == 0)
            return ans;

        // dfs
        dfs(0, "", digits, ans);
        return ans;
    }

    public static void dfs(int curPos, String curNode, String digits, List<String> ans) {
        if (curPos == digits.length()) {
            ans.add(curNode);
            return;
        }

        String letterMapping = digitToLettersMap.get(Integer.parseInt(String.valueOf(digits.charAt(curPos))));

        for (Character c : letterMapping.toCharArray()) {
            dfs(curPos + 1, curNode + c, digits, ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }


}
