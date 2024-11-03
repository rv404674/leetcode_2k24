package lc_contests.weekly_411;

class CountSubstringsThatSatisfyKSolution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < s.length(); i++) {
            for (int len = 0; len + i < n; len++) {
                String temp = s.substring(i, i + len + 1);
                if (checkValidString(temp, k)) {
                    ans++;
                }

            }
        }

        return ans;

    }

    public boolean checkValidString(String s, int k) {
        int ones = 0;
        int zeroes = 0;

        for (Character c : s.toCharArray()) {
            if (c == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }

        if (ones <= k || zeroes <= k) {
            return true;
        }

        return false;
    }
}

public class CountSubstringsThatSatisfyK {
    public static void main(String[] args) {
        CountSubstringsThatSatisfyKSolution solution = new CountSubstringsThatSatisfyKSolution();

        System.out.println(solution.countKConstraintSubstrings("10101", 1));
        System.out.println(solution.countKConstraintSubstrings("1010101", 2));
        System.out.println(solution.countKConstraintSubstrings("11111", 1));
    }
}
