package ctc;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (charCountMap.containsKey(currentChar)) {
                charCountMap.put(currentChar, charCountMap.get(currentChar) + 1);
            } else {
                charCountMap.put(currentChar, 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char currentChar = str2.charAt(i);
            if (!charCountMap.containsKey(currentChar) || charCountMap.get(currentChar) == 0) {
                return false;
            }

            charCountMap.put(currentChar, charCountMap.get(currentChar) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "dccb";

        System.out.println(str1 + " and " + str2 + "are permutations? " + isPermutation(str1, str2));
    }
}
