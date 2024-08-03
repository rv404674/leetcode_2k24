package linkedlist;

import java.util.LinkedList;

// N - Total Number of calls.
// TC - O(N)
// Space - O(size)
class MovingAverage {
    LinkedList<Integer> stream;
    int size;
    int sum;

    public MovingAverage(int size) {
        this.stream = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (this.stream.size() >= this.size) {
            // removeFirst() is O(1) for a linkedinList.
            sum -= this.stream.removeFirst();
        }

        sum += val;
        stream.add(val);
        return sum * 1.0 / this.stream.size();
    }
}

public class MovingAverageFromDataStream {

}
