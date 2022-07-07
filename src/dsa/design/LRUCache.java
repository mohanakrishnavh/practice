package dsa.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node previous, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {}
    }


    Node head, tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        cache = new HashMap<>();

        head.next = tail;
        tail.previous = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            remove(tail.previous);
        }

        insert(new Node(key, value));
    }

    private void insert(Node node) {
        cache.put(node.key, node);

        Node temp = head.next;
        head.next = node;
        node.previous = head;

        node.next = temp;
        temp.previous = node;
    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}
