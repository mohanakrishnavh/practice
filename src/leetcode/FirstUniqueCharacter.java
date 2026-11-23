package leetcode;

/**
 * FirstUniqueCharacter
 * 
 * Finds the first non-repeating character in a string.
 *
 * <p>Approach: Count lowercase letter frequencies, then scan the string again and return the
 * first index whose character has a count of exactly one.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(1) (26 counters).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FirstUniqueCharacter {

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        FirstUniqueCharacter obj = new FirstUniqueCharacter();
        System.out.println(obj.getFirstUniqueCharIndex("leetcode"));
        System.out.println(obj.getFirstUniqueCharIndex("loveleetcode"));
        System.out.println(obj.getFirstUniqueCharIndex("aabbcc"));
        System.out.println(obj.getFirstUniqueCharIndex("aabbcc"));
    }

    /**
     * Returns the index of the first non-repeating character.
     *
     * @param s a string of lowercase English letters
     * @return the index of the first unique character, or -1 if none exists
     */
    private int getFirstUniqueCharIndex(String s) {
        int[] count = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
