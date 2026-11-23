package dsa.number;

/**
 * ValidPalindrome
 * 
 * Checks whether a string is a palindrome after ignoring case and non-alphanumeric
 * characters (LeetCode 125).
 *
 * <p>Two pointers move inwards from both ends, skipping non-alphanumeric characters and comparing
 * the rest case-insensitively.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ValidPalindrome {

    /**
     * Returns whether the string is a palindrome ignoring case and punctuation.
     *
     * @param s the string to check
     * @return true if it is a palindrome (null or empty strings count as palindromes)
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
