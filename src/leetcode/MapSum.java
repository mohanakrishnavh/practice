package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    class PrefixValueNode {
        Map<Character, PrefixValueNode> children;
        int value;

        public PrefixValueNode() {
            children = new HashMap<>();
            value = 0;
        }
    }

    private PrefixValueNode root;
    private Map<String, Integer> valueMap;

    public MapSum() {
        root = new PrefixValueNode();
        valueMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        PrefixValueNode current = root;
        int delta = val - valueMap.getOrDefault(key, 0);
        valueMap.put(key, val);

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (!current.children.containsKey(c)) {
                current.children.put(c, new PrefixValueNode());
            }
            current = current.children.get(c);
            current.value += delta;
        }
    }

    public int sum(String prefix) {
        PrefixValueNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!current.children.containsKey(c)) {
                return 0;
            }

            current = current.children.get(c);
        }

        return current.value;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b", 2);
        System.out.println(mapSum.sum("a"));
    }
}
