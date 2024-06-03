package blind75.Intervals;

import java.util.Arrays;

public class MeetingRooms {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals.length <= 1)
                return true;

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int start = intervals[0][0];
            int end = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                int[] curInterval = intervals[i];

                if (end > curInterval[0]) {
                    // intersecting
                    return false;
                } else {
                    start = curInterval[0];
                    end = curInterval[1];
                }
            }

            return true;
        }

    }
}
