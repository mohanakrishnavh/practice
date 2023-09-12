package leetcode;

import java.util.Map;

public class LC0013_RomanToInteger {

    private static Map<Character, Integer> romans = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static int romanToInt(String s) {
        int intVal = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))) {
                intVal -= romans.get(s.charAt(i));
            } else {
                intVal += romans.get(s.charAt(i));
            }
        }

        return intVal;
    }
}
