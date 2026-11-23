package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * MapSum
 * 
 * Maps string keys to values and sums the values of all keys sharing a prefix.
 *
 * <p>Approach: A trie where every node stores the sum of values of keys passing through it.
 * Re-inserting an existing key applies only the delta between the new and old value, so
 * prefix sums stay correct.
 *
 * <p>Time Complexity: O(L) for both {@code insert} and {@code sum}, where L is the key or
 * prefix length. Space Complexity: O(total characters inserted).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MapSum {
    private final PrefixValueNode root;
    private final Map<String, Integer> valueMap;

    /**
     * Creates an empty MapSum.
     */
    public MapSum() {
        root = new PrefixValueNode();
        valueMap = new HashMap<>();
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b", 2);
        System.out.println(mapSum.sum("a"));
    }

    /**
     * Inserts the key-value pair, overriding the value if the key already exists.
     *
     * @param key the key to insert
     * @param val the value to associate with the key
     */
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

    /**
     * Returns the sum of the values of all keys that start with {@code prefix}.
     *
     * @param prefix the key prefix
     * @return the prefix sum, or 0 if no key matches
     */
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

    /**
     * A trie node holding child links and the sum of values of keys passing through it.
     */
    class PrefixValueNode {
        Map<Character, PrefixValueNode> children;
        int value;

        /**
         * Creates an empty node with value 0.
         */
        public PrefixValueNode() {
            children = new HashMap<>();
            value = 0;
        }
    }
}
