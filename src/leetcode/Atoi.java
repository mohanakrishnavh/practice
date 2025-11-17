package leetcode;

/**
 * LeetCode Problem 8: String to Integer (atoi)
 * Difficulty: Medium
 * 
 * <p>Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 * 
 * <p>The algorithm for myAtoi(string s) is as follows:
 * <ol>
 *   <li>Read in and ignore any leading whitespace</li>
 *   <li>Check if the next character (if not already at the end of the string) is '-' or '+'.
 *       Read this character in if it is either. This determines if the final result is negative
 *       or positive respectively. Assume the result is positive if neither is present.</li>
 *   <li>Read in next the characters until the next non-digit character or the end of the input
 *       is reached. The rest of the string is ignored.</li>
 *   <li>Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits
 *       were read, then the integer is 0. Change the sign as necessary (from step 2).</li>
 *   <li>If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp
 *       the integer so that it remains in the range. Specifically, integers less than -2^31 should
 *       be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.</li>
 *   <li>Return the integer as the final result.</li>
 * </ol>
 * 
 * <p>Example 1:
 * <pre>
 * Input: s = "42"
 * Output: 42
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: s = "   -42"
 * Output: -42
 * Explanation: Step 1: "   -42" (leading whitespace is read and ignored)
 *              Step 2: "   -42" ('-' is read, so the result should be negative)
 *              Step 3: "   -42" ("42" is read in)
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>0 <= s.length <= 200</li>
 *   <li>s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the length of the string
 * <p>Space Complexity: O(1) - only using constant extra space
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Atoi {
    
    /**
     * Converts a string to a 32-bit signed integer.
     * 
     * <p>Implements the atoi function with proper handling of:
     * <ul>
     *   <li>Leading whitespace</li>
     *   <li>Optional sign ('+' or '-')</li>
     *   <li>Numeric digits until first non-digit</li>
     *   <li>Integer overflow/underflow clamping</li>
     * </ul>
     * 
     * @param s the input string to convert
     * @return the converted integer, clamped to 32-bit signed integer range
     */
    public int stringToInteger(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        double result = 0;
        int start = 0;
        boolean isNegative = false;
        if (s.charAt(0) == '+') {
            start++;
        } else if (s.charAt(0) == '-') {
            start++;
            isNegative = true;
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }

            result = result * 10 + (int) s.charAt(i) - '0';
        }

        if (isNegative) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        return (int) result;
    }
}
