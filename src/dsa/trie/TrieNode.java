package dsa.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}
