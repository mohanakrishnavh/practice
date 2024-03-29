package dsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
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

    private static Map<Character, Integer> getCounts(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        return counts;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
