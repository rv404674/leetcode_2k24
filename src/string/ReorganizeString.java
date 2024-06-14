package string;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    /**
     * Intuition, do what you exactly did during the dry runs.
     * Greedly place everything at a distance.
     * Sort of like linear probing for hashmaps.
     *
     * @param s
     * @return
     */
    public static String reorganizeString(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // build the map
        for (Character c : s.toCharArray()) {
            if (!frequencyMap.containsKey(c))
                frequencyMap.put(c, 0);

            frequencyMap.put(c, frequencyMap.get(c) + 1);
        }

        // get the max char
        Character maxChar = null;
        int mxCount = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > mxCount) {
                mxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        // Handle off lenght as well
        // "aab"
        if (mxCount > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int idx = 0;
        // first fill the max character.
        while (frequencyMap.get(maxChar) > 0) {
            ans[idx] = maxChar;
            frequencyMap.put(maxChar, frequencyMap.get(maxChar) - 1);
            idx += 2;
        }

        // fill the char now
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Character curChar = entry.getKey();
            int cnt = entry.getValue();

            while (cnt > 0) {
                if (idx >= s.length()) idx = 1;
                ans[idx] = curChar;
                idx += 2;

                cnt -= 1;
            }
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaaabccdded"));
    }
}
