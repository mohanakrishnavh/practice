package dsa.array.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * MinimumWindowSubstring
 * 
 * Finds the smallest substring of {@code s} that contains every character of {@code t}
 * (including duplicates) (LeetCode 76) using a variable-size sliding window.
 *
 * <p>The window grows on the right until all required characters are covered, then shrinks from
 * the left to find the smallest valid window, recording the best start/end seen. A counter tracks how
 * many distinct characters of {@code t} are still not fully satisfied.
 *
 * <p>Time complexity: O(n + m). Space complexity: O(m) for the required-character map.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MinimumWindowSubstring {
    /**
     * Returns the minimum window of {@code s} containing all characters of {@code t}.
     *
     * @param s the string to search
     * @param t the string whose characters (with multiplicity) must be covered
     * @return the smallest such substring, or an empty string if none exists
     */
    public static String minimumWindow(String s, String t) {
        int start = -1;
        int end = -1;
        int minLength = Integer.MAX_VALUE;

        int length1 = s.length();
        int length2 = t.length();

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < length2; i++) {
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = countMap.size();
        int i = 0;
        int j = 0;
        while (j < length1) {
            char ch = s.charAt(j);
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) - 1);

                if (countMap.get(ch) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (j - i + 1 < minLength) {
                    start = i;
                    end = j + 1;
                    minLength = end - start + 1;
                }

                ch = s.charAt(i);
                if (countMap.containsKey(ch)) {
                    countMap.put(ch, countMap.get(ch) + 1);
                    if (countMap.get(ch) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }

        if (start != -1 && end != -1) {
            return s.substring(start, end);
        }

        return "";
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(minimumWindow("ADOBECODEBANC", "ABC"));
    }
}
