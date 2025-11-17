package ctc;

/**
 * Checks if two strings are one edit (or zero edits) away from each other.
 * An edit can be inserting a character, removing a character, or replacing a character.
 * 
 * <p>Problem from "Cracking the Coding Interview" - Chapter 1.5
 * 
 * <p>Examples:
 * <ul>
 *   <li>pale, ple -> true (remove 'a')</li>
 *   <li>pales, pale -> true (insert 's')</li>
 *   <li>pale, bale -> true (replace 'p' with 'b')</li>
 *   <li>pale, bake -> false (2 edits required)</li>
 * </ul>
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class OneAway {

    /**
     * Checks if the strings differ by exactly one character (insertion, deletion, or replacement).
     * Uses two pointers to compare characters and count differences.
     * 
     * <p>Time Complexity: O(n) where n is the length of the longer string
     * <p>Space Complexity: O(1)
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return true if strings differ by at most one edit, false otherwise
     */
    private static boolean isExtraChar(String str1, String str2) {
        int counter = 0;
        int length1 = str1.length();
        int length2 = str2.length();

        int i = 0;
        int j = 0;
        while (j < length2 || i < length1) {
            if (i >= length1 || j >= length2 || (str1.charAt(i) != str2.charAt(j))) {
                if (length1 > length2) {
                    i++;
                } else if (length2 > length1) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                counter++;
                continue;
            }
            i++;
            j++;
        }

        return counter == 1;
    }

    /**
     * Determines if two strings are one edit away from each other.
     * Handles edge cases including null strings.
     * 
     * <p>Algorithm:
     * 1. Handle null string cases
     * 2. Check if length difference is more than 1 (cannot be one edit away)
     * 3. Use helper method to check if strings differ by exactly one character
     * 
     * <p>Time Complexity: O(n) where n is the length of the longer string
     * <p>Space Complexity: O(1)
     * 
     * @param str1 the first string to compare (can be null)
     * @param str2 the second string to compare (can be null)
     * @return true if strings are one edit away, false otherwise
     */
    private static boolean isOneAway(String str1, String str2) {
        if (str1 == null) {
            if (str2 == null) {
                return false;
            } else return str2.length() == 1;
        } else if (str2 == null) {
            return str1.length() == 1;
        }

        int length1 = str1.length();
        int length2 = str2.length();

        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        return isExtraChar(str1, str2);
    }

    /**
     * Main method to test the one edit away algorithm with various examples.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
        System.out.println(isOneAway("ple", "pale"));
    }
}
