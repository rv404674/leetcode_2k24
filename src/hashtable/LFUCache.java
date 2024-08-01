package hashtable;

import java.util.HashMap;
import java.util.LinkedHashSet;

class Node {
    int key;
    int value;
    int freq;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

/**
 * LFU cache. If the cache reaches capacity, remove the one that has been accessed the least number of times.
 * Using a Simple HashMap.
 * get() - O(1), put() - O(N) (as to evict you need to traverse the whole HM).
 * <p>
 * Constraints - O(1), O(1) for both get() and put(), and in case of ties, evict the LRU one.
 * <p>
 * Similar concept as LRU Cache.
 */
class LFUCacheSolution {
    // use to store and retrieve.
    // (key, val)
    HashMap<Integer, Node> cache;

    // key - Node's freq
    // LinkedinHashSet() because we want to maintain order (as in case of ties remove LRU one)
    // and we also want O(1) contains and get.
    // Oldest element at first.
    // NOTE: The intuition is keep track of the minFreq. Once it is time to evict
    // remove the element from the freqMap that has key as minFreq.
    HashMap<Integer, LinkedHashSet<Node>> freqMap;

    int minFreq;
    int capacity;

    public LFUCacheSolution(int capacity) {
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        updateAccessedNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // already exists;
            Node node = cache.get(key);
            // Pass by Reference, will update Node's value in both the DS.
            node.value = value;
            return;
        } else {
            // cap if full
            if (cache.size() == capacity) {
                evictLFUNode();
            }

            // not full first time node insertion
            minFreq = 1;
            Node node = new Node(key, value);
            if (!freqMap.containsKey(node.freq)) {
                freqMap.put(node.freq, new LinkedHashSet<>());
            }
            freqMap.get(node.freq).add(node);
            cache.put(key, node);
        }

    }

    public void updateAccessedNode(Node node) {
        // node exists
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);

        // if set is empty and it was the minFreq
        if (set.isEmpty() && freq == minFreq) {
            minFreq++;
        }

        node.freq++;
        if (!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new LinkedHashSet<>());
        }
        freqMap.get(node.freq).add(node);
    }

    public void evictLFUNode() {
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        // remove first element (oldest as well).
        Node node = set.iterator().next();
        set.remove(node);

        // set become empty now
        if (set.isEmpty()) {
            minFreq++;
        }

        cache.remove(node.key);
    }

}

// ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
// [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
public class LFUCache {
    public static void main(String[] args) {
        LFUCacheSolution lfu = new LFUCacheSolution(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        lfu.get(2);
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        System.out.println(lfu.get(1));
        lfu.get(3);
        lfu.get(4);
    }

}
