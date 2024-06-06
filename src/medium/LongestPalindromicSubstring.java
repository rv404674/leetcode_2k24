package medium;

// Brute - O(n^3)
// Optimized - O(n^2)
public class LongestPalindromicSubstring {
    static private int ansLo;
    static private int ansHi;

    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        for (int i = 0; i < s.length(); i++) {
            // aba
            expandAroundCenter(s, i, i);
            // abba
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(ansLo, ansHi + 1);
    }

    public static void expandAroundCenter(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo -= 1;
            hi += 1;
        }

        //pabax
        lo++;
        hi--;

        if (hi - lo >= ansHi - ansLo) {
            ansHi = hi;
            ansLo = lo;
        }

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abcb"));
        System.out.println(longestPalindrome("abcba"));
    }

}
