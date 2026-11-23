package dsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FindAllAnagramsInAString
 * 
 * Finds the start indices of all anagrams of a pattern {@code p} inside a string {@code s}
 * (LeetCode 438) using a fixed-size sliding window of length {@code p.length()}.
 *
 * <p>A frequency map of {@code p} is kept and decremented as characters enter the window and
 * incremented as they leave. A counter tracks how many distinct characters still have a
 * non-zero requirement; when it reaches zero the window is an anagram.
 *
 * <p>Time complexity: O(n). Space complexity: O(k) where k is the number of distinct characters in {@code p}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindAllAnagramsInAString {
    /**
     * Finds all start indices of anagrams of {@code p} in {@code s}.
     *
     * @param s the text to search
     * @param p the pattern whose anagrams are searched for
     * @return list of start indices (empty if either input is null or empty)
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return anagrams;
        }


        Map<Character, Integer> counts = getCounts(p);
        int noOfChars = counts.size();
        int K = p.length();
        int i = 0, j = 0;
        while (j < s.length()) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);

            if (counts.containsKey(rightChar)) {
                int rightCharCount = counts.get(rightChar) - 1;
                counts.put(rightChar, rightCharCount);

                if (rightCharCount == 0) {
                    noOfChars--;
                }
            }

            if (j - i + 1 == K) {
                // Found an anagram
                if (noOfChars == 0) {
                    anagrams.add(i);
                }

                // If anagram is part of anagram string
                if (counts.containsKey(leftChar)) {
                    int leftCharCount = counts.get(leftChar);
                    if (leftCharCount == 0) {
                        noOfChars++;
                    }

                    counts.put(leftChar, leftCharCount + 1);
                }

                i++;
            }

            j++;
        }

        return anagrams;
    }

    /**
     * Builds a character frequency map for a string.
     *
     * @param s the string to count
     * @return map from character to its number of occurrences
     */
    private static Map<Character, Integer> getCounts(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        return counts;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
