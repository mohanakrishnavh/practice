package ctc;

/**
 * Replaces all spaces in a string with '%20'.
 * Assumes the string has sufficient space at the end to hold additional characters.
 * 
 * <p>Problem from "Cracking the Coding Interview" - Chapter 1.3
 * 
 * <p>Example: "Mr John Smith    " with true length 13 becomes "Mr%20John%20Smith"
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class URLify {

    /**
     * Replaces spaces with '%20' in-place in a character array.
     * Works backwards from the end of the string to avoid overwriting characters.
     * 
     * <p>Algorithm:
     * 1. Start from the true end of the string
     * 2. Move backwards, copying characters or replacing spaces with '%20'
     * 3. Use two pointers: one for reading, one for writing
     * 
     * <p>Time Complexity: O(n) where n is the true length
     * <p>Space Complexity: O(n) for the character array
     * 
     * @param inputString the string with extra space at the end
     * @param trueLength the actual length of the string (excluding extra spaces)
     * @return the URLified string with spaces replaced by '%20'
     */
    private static String urlify(String inputString, int trueLength) {
        int resultIndex = inputString.length() - 1;
        int index = trueLength - 1;
        char[] charArray = inputString.toCharArray();

        // Work backwards through the string
        while (index >= 0) {
            if (charArray[index] != ' ') {
                charArray[resultIndex] = charArray[index];
                resultIndex--;
            } else {
                // Replace space with '%20'
                charArray[resultIndex] = '0';
                charArray[resultIndex - 1] = '2';
                charArray[resultIndex - 2] = '%';
                resultIndex -= 3;
            }
            index--;
        }

        return new String(charArray);
    }

    /**
     * Main method to test the URLify algorithm.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String inputString = "Mr John Smith    ";
        int trueLength = 13;
        
        System.out.println("Original: '" + inputString + "'");
        System.out.println("URLified: '" + urlify(inputString, trueLength) + "'");
    }
}
