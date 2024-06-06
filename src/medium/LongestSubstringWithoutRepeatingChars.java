package medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    // O(2*N), O(N)
    // Wrote on my own. AC in one go. 20mins.
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int n = s.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (j < n) {
            char charJ = s.charAt(j);

            // check if it is already encountered
            // keep traversing till evyerhting becomes only one.
            while (hashMap.getOrDefault(charJ, 0) != 0) {
                char charI = s.charAt(i);
                hashMap.put(charI, hashMap.get(charI) - 1);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            hashMap.put(charJ, hashMap.getOrDefault(charJ, 0) + 1);
            j++;
        }

        return ans;
    }


    // Same idea as above.
    // When you encounter a duplicated, dont move low by +1.
    // move low directly to the new position.
    public static int lengthOfLongestSubstringOptimized(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int lo = 0;
        int hi = 0;
        int n = s.length();
        int ans = 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        while (hi < n) {
            Character charAtHi = s.charAt(hi);
            if (charIndexMap.containsKey(charAtHi)) {
                // Dry run for abba. Thats why the max.
                lo = Math.max(lo, charIndexMap.get(charAtHi) + 1);
            }

            ans = Math.max(ans, hi - lo + 1);
            charIndexMap.put(charAtHi, hi);
            hi++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String ut1 = "abba";
        System.out.println(lengthOfLongestSubstringOptimized(ut1)); //3

        String ut2 = "bbb";
        System.out.println(lengthOfLongestSubstringOptimized(ut2)); //1

        String ut3 = "abcbdeffghi";
        System.out.println(lengthOfLongestSubstringOptimized(ut3)); //5

        String ut4 = "";
        System.out.println(lengthOfLongestSubstringOptimized(ut4)); //0
    }

}
