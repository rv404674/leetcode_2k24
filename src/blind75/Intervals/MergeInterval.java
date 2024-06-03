package blind75.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (end >= interval[0]) {
                // intersecting
                end = Math.max(end, interval[1]);
            } else {
                mergedIntervals.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ut2 = {{1, 3}, {2, 7}, {8, 12}, {13, 17}, {16, 20}, {18, 25}, {22, 100}};
        System.out.println(Arrays.deepToString(merge(ut2)));
    }


}
