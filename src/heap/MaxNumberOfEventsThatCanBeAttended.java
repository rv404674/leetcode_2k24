package heap;

// Learn the concept from him
// https://www.youtube.com/watch?v=dTVB1W7-BvY


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maxEvents(int[][] events) {
        int maxEventsAttended = 0;
        int index = 0;
        int n = events.length;

        // sort the events.
        // at Day 1, pick events that start at day 1.
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int day = 1; day <= (int) 1e5; day++) {
            // pick the events - that start at this day.
            while (index < n && day == events[index][0]) {
                // insert the end time into the heap.
                // greedy makes sense to pick the event that ends first.
                minHeap.offer(events[index][1]);
                index++;
            }

            // remove events that have passed
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                // attended the event at the top of heap.
                maxEventsAttended++;
                minHeap.poll();
            }

            if (minHeap.isEmpty() && index == n) {
                break;
            }
        }

        return maxEventsAttended;
    }
}

public class MaxNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] ut1 = {{1, 10}, {2, 2}, {2, 2}, {2, 2}, {2, 2}};
        System.out.println(solution.maxEvents(ut1));
    }

}
