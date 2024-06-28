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


import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class AncestralNames {

    public static List<String> getAncestralNames(List<String> names) {
        List<String> ancestralNames = new ArrayList<>();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);

        for (String name : names) {
            String[] tokens = name.split(" ");
            String romanName = tokens[0];
            String romanForm = tokens[1];

            int total = 0;

            // Convert Roman numeral to integer
            for (int i = 0; i < romanForm.length(); i++) {
                int currentValue = hashMap.get(romanForm.charAt(i));

                if (i < romanForm.length() - 1 && hashMap.get(romanForm.charAt(i)) < hashMap.get(romanForm.charAt(i + 1))) {
                    // If current value is less than next value, subtract current value
                    total -= currentValue;
                } else {
                    // Otherwise, add current value
                    total += currentValue;
                }
            }

            // Build formatted string
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(romanName);
            stringBuilder.append(" ");
            stringBuilder.append(total);

            ancestralNames.add(stringBuilder.toString());
        }

        return ancestralNames;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Smith IX");
        names.add("Johnson II");
        names.add("Williams IV");
        names.add("Brown I");
        names.add("Wilson III");
        names.add("Adams III");

        List<String> ancestralNames = getAncestralNames(names);
        for (String ancestralName : ancestralNames) {
            System.out.println(ancestralName);
        }
    }
}

