package dsa.trie;

public class TrieDriver {
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
