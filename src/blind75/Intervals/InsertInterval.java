package blind75.Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int indexForInsertion = binSearch(intervals, newInterval);
        int[][] newIntervals = generateNewInterval(intervals, newInterval, indexForInsertion);

        List<int[]> ans = new ArrayList<>();
        int start = newIntervals[0][0];
        int end = newIntervals[0][1];

        for (int[] interval : newIntervals) {
            if (end >= interval[0]) {
                // intersection
                end = Math.max(end, interval[1]);
            } else {
                ans.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        // also add the remaining values.
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][2]);
    }

    public static int binSearch(int[][] intervals, int[] newInterval) {
        int lo = 0;
        int hi = intervals.length - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int midValue = intervals[mid][0];

            if (midValue < newInterval[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public static int[][] generateNewInterval(int[][] intervals, int[] newInterval, int index) {
        int[][] intervalsWithAddition = new int[intervals.length + 1][2];

        for (int i = 0; i < index; i++)
            intervalsWithAddition[i] = intervals[i];

        intervalsWithAddition[index] = newInterval;

        for (int i = index + 1; i < intervalsWithAddition.length; i++)
            intervalsWithAddition[i] = intervals[i - 1];

        return intervalsWithAddition;
    }

    public static void main(String[] args) {
        int[][] ut1 = {
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };

        int[] testInterval = {4, 8};
        insert(ut1, testInterval);
    }
}
