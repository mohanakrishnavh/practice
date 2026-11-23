package dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 * ValidAnagram
 * 
 * Checks whether two strings are anagrams of each other, i.e. contain the same characters
 * with the same frequencies (LeetCode 242).
 *
 * <p>Character counts of the first string are built in a map and decremented for each character of
 * the second; a counter of characters not yet fully matched must end at zero.
 *
 * <p>Time complexity: O(n). Space complexity: O(k) for k distinct characters.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ValidAnagram {

    /**
     * Returns whether {@code t} is an anagram of {@code s}.
     *
     * @param s first string
     * @param t second string
     * @return true if both strings use the same characters with the same counts
     */
    public boolean isAnagram(String s, String t) {
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
            return true;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        int uniqueChars = counts.size();
        for (char ch : t.toCharArray()) {
            if (!counts.containsKey(ch)) {
                return false;
            }

            int count = counts.get(ch) - 1;
            if (count == 0) {
                uniqueChars--;
            }
            counts.put(ch, count);
        }

        return uniqueChars == 0;
    }
}
