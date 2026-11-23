package dsa.array.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithKUniqueCharacters
 * 
 * Finds the length of the longest substring containing exactly {@code k} unique characters
 * using a variable-size sliding window.
 *
 * <p>The window expands on the right, recording character counts in a map. When the number of
 * distinct characters exceeds {@code k}, the window shrinks from the left until it is valid again.
 *
 * <p>Time complexity: O(n). Space complexity: O(k).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LongestSubstringWithKUniqueCharacters {
    /**
     * Returns the length of the longest substring with exactly {@code k} distinct characters.
     *
     * @param s the input string
     * @param k the required number of distinct characters
     * @return the maximum length, or 0 if the string is null/empty or no such substring exists
     */
    public static int lengthOfLongestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maximum = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while (j < s.length()) {
            countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) + 1);

            if (countMap.size() == k) {
                maximum = Math.max(maximum, j - i + 1);
            }

            if (countMap.size() > k) {
                while (countMap.size() > k) {
                    countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);

                    if (countMap.get(s.charAt(i)) == 0) {
                        countMap.remove(s.charAt(i));
                    }

                    i++;
                }
            }

            j++;
        }

        return maximum;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabacbebebe", 3));
        System.out.println(lengthOfLongestSubstring("abaccab", 2));
    }
}
