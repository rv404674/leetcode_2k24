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
    HashMap<Integer, LinkedHashSet<Node>> freqMap;

    int minFreq;
    int capacity;

    public LFUCacheSolution(int capacity) {
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 1;
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
            freqMap.put(node.freq, new LinkedHashSet<>());
            freqMap.get(node.freq).add(node);
            cache.put(key, node);
        }

    }

    public void updateAccessedNode(Node node) {
        // node exists
        LinkedHashSet<Node> set = freqMap.get(node.freq);
        set.remove(node);

        node.freq++;
        minFreq = Math.min(minFreq, node.freq);
        set.add(node);
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

public class LFUCache {
    
}
