package medium;

import java.util.HashMap;

class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// INTUITION
// NOTE: assumption - head means the latest value.
// DLL + hashmap
// To insert (assyming a node already exists), you first need to remove this node and put it back in the head.
// To do this in O(1), you need to know the address of the node. Hence store it in the hashmap.
public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.hashMap = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        Node node = hashMap.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            remove(hashMap.get(key));
        } else if (hashMap.size() == capacity) {
            // remove the tail
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    // Picture the node in between two nodes. Then delete.
    public void remove(Node node) {
        hashMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // insert at the front.
    public void insert(Node node) {
        hashMap.put(node.key, node);
        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }


}
