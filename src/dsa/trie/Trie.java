package dsa.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i=0; i<word.length(); i++) {
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
       for (int i=0; i<word.length(); i++) {
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
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("pranam");
        trie.insert("parvesh");
        trie.insert("arshi");
        trie.insert("mohan");
        trie.insert("vinaya");

        System.out.println(trie.search("vinaya"));
        System.out.println(trie.search("trump"));
        System.out.println(trie.startsWith("be"));
        System.out.println(trie.startsWith("p"));
    }
}
