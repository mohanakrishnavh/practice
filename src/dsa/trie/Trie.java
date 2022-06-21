package dsa.trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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
