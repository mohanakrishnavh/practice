package leetcode;

public class BreakPalindrome {
    public static String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }

        for (int i=0; i<palindrome.length()/2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.replaceFirst(String.valueOf(palindrome.charAt(i)), "a");
            }
        }

        palindrome = palindrome.substring(0, palindrome.length()-1) + "b";
        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println(BreakPalindrome.breakPalindrome("aba"));
    }
}
