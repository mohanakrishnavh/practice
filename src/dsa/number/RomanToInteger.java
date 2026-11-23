package dsa.number;


import java.util.HashMap;
import java.util.Map;

/**
 * RomanToInteger
 * 
 * Converts a Roman numeral to an integer (LeetCode 13).
 *
 * <p>Symbols are read left to right: a symbol smaller than the one after it (as in IV or IX) is
 * subtracted, otherwise it is added.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RomanToInteger {

    private static Map<Character, Integer> romans = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    /**
     * Converts a Roman numeral to its integer value.
     *
     * @param s a valid Roman numeral string
     * @return the integer value
     */
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
