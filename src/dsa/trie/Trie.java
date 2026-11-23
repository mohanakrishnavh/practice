package dsa.trie;

/**
 * Trie
 * 
 * A trie (prefix tree) for storing and looking up strings character by character (LeetCode 208).
 *
 * <p>Each node maps a character to a child node, and a flag marks nodes where a stored word ends.
 * Words sharing a prefix share the same path from the root.
 *
 * <p>Time complexity: insert, search and startsWith are O(L) where L is the length of the word or prefix.
 * Space complexity: O(total characters stored).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Trie {
    /**
     * Root node of the trie; it represents the empty prefix.
     */
    private final TrieNode root;

    /**
     * Creates an empty trie.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word, creating nodes for any characters not already present.
     *
     * @param word the word to insert
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }

            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }

    /**
     * Checks whether the exact word was inserted.
     *
     * @param word the word to look up
     * @return true if the word is in the trie
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return current.isEndOfWord;
    }

    /**
     * Checks whether any inserted word begins with the given prefix.
     *
     * @param prefix the prefix to look up
     * @return true if some word in the trie starts with {@code prefix}
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }
}
