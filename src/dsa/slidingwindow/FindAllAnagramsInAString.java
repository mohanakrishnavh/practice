package dsa.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char character = p.charAt(i);
            countMap.put(character, countMap.getOrDefault(character, 0) + 1);
        }

        int k = p.length();
        int numberOfCharacters = countMap.size();

        int i = 0;
        int j = 0;
        List<Integer> anagrams = new ArrayList<>();
        while (j < s.length()) {
            countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) - 1);

            if (countMap.get(s.charAt(j)) == 0) {
                numberOfCharacters--;
            }

            if (j - i + 1 == k) {
                if (numberOfCharacters == 0) {
                    anagrams.add(i);
                }

                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
                if (countMap.get(s.charAt(i)) == 1) {
                    numberOfCharacters++;
                }

                i++;
            }

            j++;
        }


        return anagrams;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
