package dsa.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * TrieNode
 * 
 * A node of a {@link Trie}. It holds a map from character to child node and a flag marking
 * whether a stored word ends at this node.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TrieNode {
    /**
     * True if a word ends at this node.
     */
    boolean isEndOfWord;
    /**
     * Child nodes keyed by the next character.
     */
    Map<Character, TrieNode> children;

    /**
     * Creates a node with no children that does not mark the end of a word.
     */
    public TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}
