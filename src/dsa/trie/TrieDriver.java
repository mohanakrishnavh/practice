package dsa.trie;

/**
 * TrieDriver
 * 
 * Demo driver for {@link Trie}: inserts a few words, then runs search and prefix queries and prints the results.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TrieDriver {
    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
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
