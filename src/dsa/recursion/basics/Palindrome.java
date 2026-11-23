package dsa.recursion.basics;

/**
 * Palindrome
 *
 * <p>Checks whether a string reads the same forwards and backwards.
 *
 * <p><b>Idea:</b> compare the character at index {@code i} with its mirror at {@code length - i - 1},
 * moving inward. Only the first half needs checking, so stop once {@code i >= length / 2}.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack (n/2 frames).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Palindrome {
    /**
     * Public entry point: starts the comparison from index 0.
     *
     * @param s the string to check
     * @return {@code true} if {@code s} reads the same forwards and backwards
     */
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0);
    }

    /**
     * Compares the character at {@code i} with its mirror, then recurses inward.
     *
     * @param s the string to check
     * @param i index of the left character of the current pair; start with 0
     * @return {@code true} if every pair from {@code i} to the middle matches
     */
    public static boolean isPalindrome(String s, int i) {
        // Base case: every pair in the first half matched (also covers the middle char of odd lengths)
        if (i >= s.length()/2) {
            return true;
        }

        // Mismatch with the mirrored character -> not a palindrome, stop early
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }

        // Move one step inward
        return isPalindrome(s, i + 1);
    }

    /**
     * Demo: checks "MADAM", "11211" and "MIKE" and prints the results.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("MADAM")); // true
        System.out.println(isPalindrome("11211")); // true
        System.out.println(isPalindrome("MIKE"));  // false
    }
}
