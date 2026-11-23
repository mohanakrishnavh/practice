package dsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * CountOccurrencesOfAnagrams
 *
 * Counts how many substrings of a text are anagrams of a given pattern, using a fixed-size
 * sliding window of length {@code pat.length()}.
 *
 * <p>Example: pattern {@code "for"} in {@code "forxxorfxdofr"} gives 3
 * ({@code "for"}, {@code "orf"}, {@code "ofr"}).
 *
 * <p>Approach: A frequency map of the pattern is kept as the "still needed" counts. A character
 * entering the window decrements its count and one leaving increments it. {@code count} tracks
 * how many distinct pattern characters are not yet fully satisfied; when it reaches zero the
 * current window is an anagram.
 *
 * <p>Time complexity: O(n) where n is the text length. Space complexity: O(d) where d is the
 * number of distinct characters.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CountOccurrencesOfAnagrams {

    /**
     * Counts the windows of {@code txt} that are anagrams of {@code pat}.
     *
     * @param pat the pattern whose anagrams are counted
     * @param txt the text to search
     * @return the number of anagram occurrences, or 0 if either input is empty
     * or the pattern is longer than the text
     */
    public int search(String pat, String txt) {
        if (pat.isEmpty() || txt.isEmpty()) {
            return 0;
        }

        // Needed count of each pattern character
        Map<Character, Integer> countMap = new HashMap<>();
        char ch;
        for (int i = 0; i < pat.length(); i++) {
            ch = pat.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Window is [i, j] with fixed size k; count = distinct chars still not satisfied
        int i = 0, j = 0, k = pat.length(), anagrams = 0;
        int count = countMap.size();
        while (j < txt.length()) {
            // Entering char: consume one needed occurrence (goes negative if extra or not in pattern)
            countMap.put(txt.charAt(j), countMap.getOrDefault(txt.charAt(j), 0) - 1);
            if (countMap.get(txt.charAt(j)) == 0) {
                // This pattern char is now exactly satisfied
                countMap.remove(txt.charAt(j));
                count--;
            }

            // Window is full (if pat is longer than txt this is never reached, so result is 0)
            if (j - i + 1 == k) {
                // Every pattern char satisfied exactly -> this window is an anagram
                if (count == 0) {
                    anagrams++;
                }

                // Leaving char: give back one occurrence
                ch = txt.charAt(i);
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                // Value 1 means it was fully satisfied before leaving, so it is needed again
                if (countMap.get(ch) == 1) {
                    count++;
                }

                i++;
            }

            j++;
        }

        return anagrams;
    }

    /**
     * Runs one test case and prints PASS or FAIL.
     *
     * @param name     a short description of the case
     * @param pat      the pattern
     * @param txt      the text
     * @param expected the expected anagram count
     */
    private static void check(String name, String pat, String txt, int expected) {
        int actual = new CountOccurrencesOfAnagrams().search(pat, txt);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        check("typical, scattered matches", "for", "forxxorfxdofr", 3);
        check("overlapping matches", "aaba", "aabaabaa", 4);
        check("pattern repeated in text", "ab", "abab", 3);
        check("chars outside the pattern in text", "abc", "abcdcba", 2);
        check("duplicate pattern chars, excess in window", "aab", "aaab", 1);
        check("single char pattern", "a", "aaaa", 4);
        check("no anagram present", "abc", "xyzxyz", 0);
        check("pattern equals text", "abc", "cab", 1);
        check("pattern longer than text", "abcd", "abc", 0);
        check("empty pattern", "", "abc", 0);
        check("empty text", "abc", "", 0);
    }
}
