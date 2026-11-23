package dsa.array.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithoutRepeatingCharacters
 * 
 * Finds the length of the longest substring without repeating characters (LeetCode 3)
 * using a variable-size sliding window.
 *
 * <p>A character count map is maintained for the window. The window is valid when its size equals
 * the number of distinct characters in it; otherwise it shrinks from the left until no duplicates remain.
 *
 * <p>Time complexity: O(n). Space complexity: O(min(n, alphabet size)).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Returns the length of the longest substring with all distinct characters.
     *
     * @param s the input string
     * @return the maximum length, or 0 if the string is null or empty
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maximum = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while (j < s.length()) {
            countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 == countMap.size()) {
                maximum = Math.max(maximum, j - i + 1);
            }

            if (countMap.size() < j - i + 1) {
                while (countMap.size() < j - i + 1) {
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
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
