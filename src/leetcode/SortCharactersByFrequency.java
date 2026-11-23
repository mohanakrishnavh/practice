package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * SortCharactersByFrequency
 * 
 * Sorts the characters of a string by decreasing frequency.
 *
 * <p>Approach: Count characters in a map, order them in a max heap by count, then append each
 * character repeated by its count.
 *
 * <p>Time Complexity: O(n + d log d) where d is the number of distinct characters.
 * Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SortCharactersByFrequency {
    /**
     * Returns the string with characters grouped and ordered by descending frequency.
     *
     * @param s the input string
     * @return the sorted string, or an empty string if the input is null or empty
     */
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = counts.get(ch);
            String key = Character.toString(ch);
            sb.append(key.repeat(count));
        }

        return sb.toString();
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(SortCharactersByFrequency.frequencySort("tree"));
        System.out.println(SortCharactersByFrequency.frequencySort("cccaaa"));
        System.out.println(SortCharactersByFrequency.frequencySort("Aabb"));
    }
}
