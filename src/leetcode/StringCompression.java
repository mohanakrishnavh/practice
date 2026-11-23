package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * StringCompression
 * 
 * Compresses a character array by replacing runs of repeated characters with the
 * character followed by the run length.
 *
 * <p>Example: {@code [a,a,b,b,c,c,c]} compresses to {@code a2b2c3} (length 6).
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n) for the intermediate list.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class StringCompression {
    /**
     * Returns the length of the compressed form of {@code chars}.
     *
     * @param chars the characters to compress
     * @return the compressed length, or 0 if the input is null or empty
     */
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        List<Character> compressedString = new ArrayList<>();
        char current = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count > 1) {
                    compressedString.add(current);
                    compressedString.add(Character.forDigit(count, 10));

                    current = chars[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }

        compressedString.add(current);
        if (count > 1) {
            compressedString.add(Character.forDigit(count, 10));
        }

        return compressedString.size();
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(StringCompression.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
