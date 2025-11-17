package dsa.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * TrieNode
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}
