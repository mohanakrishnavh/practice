package dsa.mathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FindDigits
 * 
 * Extracts the digits of a number in a given base by repeated division.
 *
 * <p>Each step takes {@code n % base} as the next (least significant) digit and divides {@code n}
 * by the base; the collected digits are then reversed so the most significant digit comes first.
 *
 * <p>Time complexity: O(log n) for the given base.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindDigits {
    /**
     * Returns the digits of {@code n} in the given base, most significant first.
     *
     * @param n    the number to convert
     * @param base the base to use (e.g. 10 for decimal, 2 for binary)
     * @return list of digits (empty if {@code n} is 0)
     */
    public static List<Integer> getDigits(int n, int base) {
        List<Integer> digits = new ArrayList<>();
        if (n == 0) {
            return digits;
        }

        while (n != 0) {
            int remainder = n % base;
            digits.add(remainder);
            n = n/base;
        }

        Collections.reverse(digits);
        return digits;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(getDigits(125, 10));
        System.out.println(getDigits(125, 2));
    }
}
