package ctc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to check if a string has all unique characters.
 * Implements multiple algorithms with different time and space complexities.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class IsUnique {

    /**
     * Checks if all characters in a string are unique using nested loops.
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 
     * @param inputString the string to check for unique characters
     * @return true if all characters are unique, false otherwise
     */
    private static boolean isUnique1(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < inputString.length(); j++) {
                if (i == j) {
                    continue;
                }

                if (inputString.charAt(i) == inputString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if all characters in a string are unique using a HashSet.
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * @param inputString the string to check for unique characters
     * @return true if all characters are unique, false otherwise
     */
    private static boolean isUnique2(String inputString) {
        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (characters.contains(inputString.charAt(i))) {
                return false;
            }

            characters.add(inputString.charAt(i));
        }
        return true;
    }

    /**
     * Checks if all characters in a string are unique by sorting and comparing adjacent characters.
     * Time complexity: O(n log n)
     * Space complexity: O(n) for the character array
     * 
     * @param inputString the string to check for unique characters
     * @return true if all characters are unique, false otherwise
     */
    private static boolean isUnique3(String inputString) {
        char[] inputChars = inputString.toCharArray();
        Arrays.sort(inputChars);

        for (int i = 0; i < inputChars.length - 1; i++) {
            if (inputChars[i] == inputChars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to test the unique character checking algorithms.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcdddeee";

        System.out.println(str1 + " is unique? :" + isUnique3(str1));
        System.out.println(str2 + " is unique? :" + isUnique3(str2));
    }
}
