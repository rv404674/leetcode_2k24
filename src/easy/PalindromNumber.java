package easy;

public class PalindromNumber {
    public static boolean isPalindrome(int x) {
        // basic one
        if (x < 0)
            return false;

        String xString = Integer.toString(x);
        int n = xString.length();

        for (int i = 0; i < n / 2; i++) {
            if (xString.charAt(i) != xString.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeOptimized(int x) {
        if (x == 0)
            return true;

        if (x < 0 || x % 10 == 0)
            return false;

        int revertedNum = 0;
        int originalNum = x;

        while (x != 0) {
            revertedNum = revertedNum * 10 + x % 10;
            x = x / 10;
        }

        if (revertedNum == originalNum)
            return true;

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPalindromeOptimized(2345));
        System.out.println(isPalindromeOptimized(232));
        System.out.println(isPalindromeOptimized(11));
        System.out.println(isPalindromeOptimized(12));
        System.out.println(isPalindromeOptimized(10));

        System.out.println(isPalindromeOptimized(-11));
    }
}
