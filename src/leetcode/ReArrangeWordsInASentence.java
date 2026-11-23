package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * ReArrangeWordsInASentence
 * 
 * Rearranges the words of a sentence by increasing length.
 *
 * <p>Approach: Group words by length in a {@code TreeMap} (keeping original order within a
 * length), lowercase them, join in key order and capitalise the first letter.
 *
 * <p>Time Complexity: O(n log n) in the number of distinct lengths. Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReArrangeWordsInASentence {
    /**
     * Returns the sentence with words ordered by length (ties keep original order).
     *
     * @param text a sentence of space-separated words starting with a capital letter
     * @return the rearranged sentence, capitalised, or an empty string if the input is null or empty
     */
    public static String arrangeWords(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        String[] words = text.split(" ");
        TreeMap<Integer, List<String>> countMap = new TreeMap<>();

        for (String word : words) {
            countMap.computeIfAbsent(word.length(), x -> new ArrayList<>()).add(word.toLowerCase());
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> wordList : countMap.values()) {
            for (String word : wordList) {
                sb.append(word + " ");
            }
        }

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString().trim();
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(ReArrangeWordsInASentence.arrangeWords("Leetcode is cool"));
        System.out.println(ReArrangeWordsInASentence.arrangeWords("Keep calm and code on"));
        System.out.println(ReArrangeWordsInASentence.arrangeWords("To be or not to be"));
    }
}
