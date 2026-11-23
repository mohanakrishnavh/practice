package dsa.number;

/**
 * IntegerToRoman
 * 
 * Converts an integer in the range 1 to 3999 to a Roman numeral (LeetCode 12).
 *
 * <p>Lookup tables hold the Roman representation of every digit value for the thousands, hundreds,
 * tens and ones places, so the result is the concatenation of one entry per decimal digit.
 *
 * <p>Time complexity: O(1). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class IntegerToRoman {

    private static final String[] M = {"", "M", "MM", "MMM"};
    private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /**
     * Converts a number to its Roman numeral.
     *
     * @param num the number to convert (1 to 3999)
     * @return the Roman numeral string
     */
    public static String intToRoman(int num) {
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

}
