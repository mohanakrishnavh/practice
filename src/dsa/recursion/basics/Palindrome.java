package dsa.recursion.basics;

/**
 * Palindrome
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0);
    }

    public static boolean isPalindrome(String s, int i) {
        if (i >= s.length()/2) {
            return true;
        }

        if (s.charAt(i) != s.charAt(s.length()-i-1)) {
            return false;
        }

        return isPalindrome(s, i+1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("MADAM"));
        System.out.println(isPalindrome("11211"));
        System.out.println(isPalindrome("MIKE"));
    }
}
