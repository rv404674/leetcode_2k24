package blind75;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] ut1 = {805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(ut1, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int mx = Integer.MIN_VALUE;
        int minSpeed = Integer.MAX_VALUE;

        for (Integer pile : piles)
            mx = Math.max(pile, mx);

        // binary search
        int lo = 1;
        int hi = mx;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int totalHours = hoursTaken(piles, mid, h);

            if (totalHours <= h) {
                minSpeed = Math.min(minSpeed, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return minSpeed;
    }

    public static int hoursTaken(int[] piles, int currRate, int limit) {
        int timeTaken = 0;
        for (Integer pile : piles) {
            timeTaken += Math.ceil((double) (pile) / (double) (currRate));
        }

        return timeTaken;
    }


}
