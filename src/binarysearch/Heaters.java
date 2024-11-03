package binarysearch;

import java.util.Arrays;
import java.util.List;

class HeatersSolution {
    /**
     * Intuition - Sort heaters and then find the heaters (lower, upper) that can serve a house.
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int ans = -1;
        for (int house : houses) {
            List<Integer> distance = binarySearch(heaters, house);
            int lower = distance.get(0);
            int upper = distance.get(1);

            int lowerDistance = (lower == -1 ? Integer.MAX_VALUE : house - lower);
            int upperDistance = (upper == -1 ? Integer.MAX_VALUE : upper - house);

            ans = Math.max(ans, Math.min(lowerDistance, upperDistance));
        }

        return ans;
    }

    public List<Integer> binarySearch(int[] heaters, int house) {
        int lo = 0;
        int hi = heaters.length - 1;

        int lower = -1;
        int upper = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (heaters[mid] == house) {
                return Arrays.asList(house, house);
            }

            if (heaters[mid] < house) {
                lower = heaters[mid];
                lo = mid + 1;
            } else {
                upper = heaters[mid];
                hi = mid - 1;
            }
        }

        return Arrays.asList(lower, upper);
    }


}

public class Heaters {
    public static void main(String[] args) {
        HeatersSolution heatersSolution = new HeatersSolution();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};

        heatersSolution.findRadius(houses, heaters);
    }
}
