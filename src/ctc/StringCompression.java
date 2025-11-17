package ctc;

/**
 * Performs basic string compression using counts of repeated characters.
 * For example, "aabcccccaaa" would become "a2b1c5a3".
 * If the compressed string is not smaller than the original, return the original.
 * 
 * <p>Problem from "Cracking the Coding Interview" - Chapter 1.6
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class StringCompression {

    /**
     * Compresses a string by replacing consecutive repeated characters
     * with the character followed by its count.
     * 
     * <p>Algorithm:
     * 1. Iterate through the string counting consecutive characters
     * 2. When a different character is found, append character and count
     * 3. Continue until end of string
     * 
     * <p>Time Complexity: O(n) where n is the length of the string
     * <p>Space Complexity: O(n) for the StringBuilder result
     * 
     * @param str the string to compress
     * @return the compressed string, or empty string if input is null/empty
     */
    private static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int length = str.length();
        int counter = 0;

        for (int i = 0; i < length - 1; i++) {
            char currentChar = str.charAt(i);
            counter++;

            // If current char differs from next, append char and count
            if (currentChar != str.charAt(i + 1)) {
                result.append(currentChar);
                result.append(counter);
                counter = 0;
            }
        }
        
        // Append the last character and its count
        result.append(str.charAt(length - 1));
        result.append(++counter);

        return result.toString();
    }

    /**
     * Main method to test the string compression algorithm with various examples.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aabccccca"));
        System.out.println(compress(""));
        System.out.println(compress(null));
        System.out.println(compress("abcd"));
    }
}
