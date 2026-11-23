package leetcode;

/**
 * BreakPalindrome
 * 
 * Breaks a palindrome by changing exactly one character so that the result is the
 * lexicographically smallest string that is not a palindrome.
 *
 * <p>Approach: Replace the first non-'a' character in the first half with 'a'. If the first half
 * is all 'a's, change the last character to 'b'.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n) for the new string.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BreakPalindrome {
    /**
     * Returns the smallest non-palindrome obtainable by changing one character.
     *
     * @param palindrome the input palindrome
     * @return the modified string, or an empty string if the input is null or has length 1
     */
    public static String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }

        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.replaceFirst(String.valueOf(palindrome.charAt(i)), "a");
            }
        }

        palindrome = palindrome.substring(0, palindrome.length() - 1) + "b";
        return palindrome;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(BreakPalindrome.breakPalindrome("aba"));
    }
}
