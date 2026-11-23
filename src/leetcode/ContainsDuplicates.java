package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * ContainsDuplicates
 * 
 * Checks whether an array contains any duplicate value.
 *
 * <p>Approach: Insert elements into a {@code HashSet}; seeing an element already in the set
 * means a duplicate exists.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ContainsDuplicates {
    /**
     * Returns whether any value appears more than once.
     *
     * @param nums the input array
     * @return true if a duplicate exists, false otherwise
     */
    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }

            uniqueNums.add(num);
        }

        return false;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[]{1, 2, 3, 4}));
        System.out.println(hasDuplicates(new int[]{1, 2, 2, 4}));
        System.out.println(hasDuplicates(new int[]{}));
    }
}
