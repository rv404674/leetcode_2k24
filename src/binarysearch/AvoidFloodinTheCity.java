package binarysearch;

import java.util.HashMap;
import java.util.TreeSet;

class AvoidFloodinTheCity {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> lakeMap = new HashMap();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int n = rains.length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                continue;
            }

            // lakeMap already contains this lake.
            // prevent it from flooding.
            if (lakeMap.containsKey(rains[i])) {
                Integer dryDay = dryDays.ceiling(lakeMap.get(rains[i]));
                if (dryDay == null) {
                    return new int[]{};
                }

                // At day dryDay, lake (rains[i]) will be dryed up.
                ans[dryDay] = rains[i];
                dryDays.remove(dryDay);
            }

            ans[i] = -1;
            lakeMap.put(rains[i], i);
        }

        // default placeholder.
        while (!dryDays.isEmpty()) {
            int top = dryDays.first();
            ans[top] = 1;
            dryDays.remove(top);
        }

        return ans;

    }

}
