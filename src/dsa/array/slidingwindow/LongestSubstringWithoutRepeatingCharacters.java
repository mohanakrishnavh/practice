package dsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithoutRepeatingCharacters
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
