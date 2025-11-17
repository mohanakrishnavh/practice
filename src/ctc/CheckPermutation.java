package ctc;

import java.util.HashMap;
import java.util.Map;

/**
 * Checks if one string is a permutation of another string.
 * A permutation means the strings contain the same characters with the same frequencies,
 * but possibly in a different order.
 * 
 * <p>Problem from "Cracking the Coding Interview" - Chapter 1.2
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CheckPermutation {

    /**
     * Determines if two strings are permutations of each other.
     * Uses a HashMap to count character frequencies.
     * 
     * <p>Algorithm:
     * 1. Check if lengths are equal (if not, cannot be permutations)
     * 2. Count character frequencies in first string using HashMap
     * 3. Decrement counts for characters in second string
     * 4. If any character is missing or count goes negative, return false
     * 
     * <p>Time Complexity: O(n) where n is the length of the strings
     * <p>Space Complexity: O(k) where k is the number of unique characters
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return true if str2 is a permutation of str1, false otherwise
     */
    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Count character frequencies in str1
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (charCountMap.containsKey(currentChar)) {
                charCountMap.put(currentChar, charCountMap.get(currentChar) + 1);
            } else {
                charCountMap.put(currentChar, 1);
            }
        }

        // Decrement counts for characters in str2
        for (int i = 0; i < str2.length(); i++) {
            char currentChar = str2.charAt(i);
            if (!charCountMap.containsKey(currentChar) || charCountMap.get(currentChar) == 0) {
                return false;
            }
            charCountMap.put(currentChar, charCountMap.get(currentChar) - 1);
        }

        return true;
    }

    /**
     * Main method to test the permutation checking algorithm.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "dccb";

        System.out.println(str1 + " and " + str2 + " are permutations? " + isPermutation(str1, str2));
    }
}
