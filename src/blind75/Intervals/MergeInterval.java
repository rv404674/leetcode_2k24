package blind75.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            // if intersection
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ut2 = {{1, 3}, {2, 7}, {8, 12}, {13, 17}, {16, 20}, {18, 25}, {22, 100}};
        System.out.println(Arrays.deepToString(merge(ut2)));
    }


}
