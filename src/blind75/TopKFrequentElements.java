package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Element implements Comparable<Element> {
    int frequency;
    int elementValue;

    Element(int count, int value) {
        this.frequency = count;
        this.elementValue = value;
    }


    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}

public class TopKFrequentElements {
    // NOTE: Intention is to get AC in first go itself.
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        List<Integer> topElements = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        // key is elementValue, and value is frequence
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            minHeap.offer(new Element(entry.getValue(), entry.getKey()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            topElements.add(minHeap.poll().elementValue);
        }

        return topElements.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] ut1 = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(ut1, k)));


    }
}
