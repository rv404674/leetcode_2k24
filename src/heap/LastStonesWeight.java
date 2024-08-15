package heap;

import java.util.PriorityQueue;

public class LastStonesWeight {

    // TC - Nlog(N)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            if (firstStone == secondStone) {
                continue;
            }

            maxHeap.offer(firstStone - secondStone);
        }

        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        }

        return 0;
    }

}
