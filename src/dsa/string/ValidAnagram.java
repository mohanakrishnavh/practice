package dsa.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

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
