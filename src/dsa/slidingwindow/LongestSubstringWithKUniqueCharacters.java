package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabacbebebe", 3));
        System.out.println(lengthOfLongestSubstring("abaccab", 2));
    }
}
