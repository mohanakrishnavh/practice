package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0146_LRUCache {
    Node head, tail;
    int capacity;
    Map<Integer, Node> cache;

    public LC0146_LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.previous = head;
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } else if (cache.size() == capacity) {
            remove(tail.previous);
        }

        insert(new Node(key, value));
    }

    private void insert(Node node) {
        // Insert into the cache
        cache.put(node.key, node);

        // Insert the node at the head of the DLL
        node.next = head.next;
        node.next.previous = node;
        head.next = node;
        node.previous = head;
    }

    private void remove(Node node) {
        // Remove from the cache
        cache.remove(node.key);

        // Remove from the DLL
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LC0146_LRUCache cache = new LC0146_LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
