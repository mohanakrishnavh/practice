package dsa.design;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 * 
 * <p>This class implements a Least Recently Used (LRU) Cache with O(1) time complexity for both
 * get and put operations. Uses a combination of HashMap (for O(1) lookup) and doubly-linked list
 * (for O(1) insertion/deletion). The most recently used items are kept at the front of the list,
 * and the least recently used items are at the back, making eviction efficient.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LRUCache {
    /**
     * Node class for the doubly-linked list used in the LRU cache.
     */
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head, tail;
    Map<Integer, Node> cache;

    /**
     * Initializes the LRU cache with the specified capacity.
     * 
     * <p>Creates sentinel head and tail nodes to simplify list operations.
     * 
     * @param capacity the maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves the value associated with the key if it exists in the cache.
     * 
     * <p>Marks the key as recently used by moving it to the front of the list.
     * 
     * <p>Time Complexity: O(1)
     * 
     * @param key the key to look up
     * @return the value associated with the key, or -1 if the key doesn't exist
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    /**
     * Inserts or updates a key-value pair in the cache.
     * 
     * <p>If the key exists, updates its value and moves it to the front.
     * If the cache is at capacity, evicts the least recently used item (at the back).
     * 
     * <p>Time Complexity: O(1)
     * 
     * @param key the key to insert or update
     * @param value the value to associate with the key
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    /**
     * Inserts a node at the front of the list (most recently used position).
     * 
     * @param node the node to insert
     */
    private void insert(Node node) {
        cache.put(node.key, node);

        Node temp = head.next;
        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }

    /**
     * Removes a node from the list and the cache map.
     * 
     * @param node the node to remove
     */
    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
