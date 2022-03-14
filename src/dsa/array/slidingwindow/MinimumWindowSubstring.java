package dsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
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

    public static void main(String[] args) {
        System.out.println(minimumWindow("ADOBECODEBANC", "ABC"));
    }
}
