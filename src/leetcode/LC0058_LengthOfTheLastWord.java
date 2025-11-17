package leetcode;

/**
 * LeetCode Problem 58: Length of Last Word
 * Difficulty: Easy
 * 
 * <p>Return the length of the last word in a string.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0058_LengthOfTheLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = s.length() - 1;
        // Removing any trailing white space
        while (s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;
        // Computing the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
