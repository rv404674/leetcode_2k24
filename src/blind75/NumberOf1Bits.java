package blind75;

public class NumberOf1Bits {
    public static void main(String[] args) {
//        int ut1 = 11;
//        System.out.println(hammingWeight(ut1));

        int u2 = 128;
        System.out.println(hammingWeight(u2));

        int ut3 = 2147483645;
        System.out.println(hammingWeight(ut3));

    }

    public static int hammingWeight(int n) {
        int ans = 0;
        while (n > 0) {
            int left = n % 2;
            n = n / 2;

            if (left == 1) {
                ans += 1;
            }
        }

        return ans;
    }

}
