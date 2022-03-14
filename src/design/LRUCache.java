package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private LinkedList<Integer> cacheKeys;
    private Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheKeys = new LinkedList<>();
        cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // Move the element to the start of the cacheKeys


            return cacheMap.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {

    }
}
