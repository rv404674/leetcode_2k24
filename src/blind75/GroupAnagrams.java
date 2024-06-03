package blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramHashMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            char[] count = new char[26];
            for (char c : s.toCharArray())
                count[c - 'a']++;

            String countString = new String(count);

            List<String> anagrams = anagramHashMap.getOrDefault(countString, new ArrayList<>());
            anagrams.add(s);
            anagramHashMap.put(countString, anagrams);
        }

        ans.addAll(anagramHashMap.values());

        return ans;
    }

    public static void main(String[] args) {
        String[] ut1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(ut1));
    }

}
