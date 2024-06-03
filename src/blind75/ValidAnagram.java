package blind75;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++)
            countS[s.charAt(i) - 'a'] = countS[s.charAt(i) - 'a'] + 1;

        for (int i = 0; i < t.length(); i++)
            countT[t.charAt(i) - 'a'] = countT[t.charAt(i) - 'a'] + 1;

        for (int i = 0; i < 25; i++)
            if (countS[i] != countT[i]) return false;

        return true;
    }

    public boolean isAnagramUsingHashMap(String s, String t) {
        HashMap<Character, Integer> charCountS = new HashMap<>();
        HashMap<Character, Integer> charCountT = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountS.put(c, charCountS.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
        }

        // compare size
        if (charCountS.size() != charCountT.size()) return false;

        // compare both hashmaps
        for (Character c : charCountS.keySet()) {
            if (!charCountT.containsKey(c) || charCountS.get(c) != charCountT.get(c)) {
                return false;
            }
        }

        return true;
    }
}
