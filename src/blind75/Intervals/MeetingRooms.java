package blind75.Intervals;

import java.util.Arrays;

public class MeetingRooms {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals.length <= 1)
                return true;

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int start = -1, end = -1;

            for (int i = 0; i < intervals.length; i++) {
                int[] curInterval = intervals[i];

                if (i != 0 && end > curInterval[0]) {
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
