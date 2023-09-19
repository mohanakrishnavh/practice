package dsa.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    TrieNode root;

    class TrieNode {
        int sum;
        Map<Character, TrieNode> children;

        public TrieNode() {
            sum = 0;
            children = new HashMap<>();
        }

        public void addValue(int val) {
            sum += val;
        }

        public int getSum() {
            return sum;
        }
    }

    public MapSumPairs() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }

            current.addValue(val);
            current = current.children.get(ch);
        }
    }

    public int sum(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!current.children.containsKey(ch)) {
                break;
            }

            current = current.children.get(ch);
        }

        return current.getSum();
    }

     // ["MapSum","insert","sum","insert","sum"]
     // [[],["apple",3],["apple"],["app",2],["ap"]]
    public static void main(String[] args){
        MapSumPairs mapSumPairs = new MapSumPairs();
        mapSumPairs.insert("apple", 3);
        System.out.println(mapSumPairs.sum("apple"));
        mapSumPairs.insert("app", 2);
        System.out.println(mapSumPairs.sum("ap"));
    }
}
