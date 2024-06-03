package blind75.Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1)
            return 1;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int meetStartTime = interval[0];
            int meetEndTime = interval[1];

            // this meeting room can be used again.
            if (!minHeap.isEmpty() && minHeap.peek() <= meetStartTime) {
                minHeap.poll();
            }

            minHeap.add(meetEndTime);
        }

        // You dont need to compute max at every step.
        // minheap would always have the total meeting rooms.
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {2, 4}, {7, 10}, {11, 15}, {13, 20}, {21, 25}, {23, 27}, {30, 35}
        };

        System.out.println(minMeetingRooms(intervals));


    }

}
