package dsa.number;

/**
 * SingleNumber
 * 
 * Finds the element that appears exactly once in an array where every other element appears
 * twice (LeetCode 136).
 *
 * <p>XOR-ing all values cancels the pairs (a ^ a = 0, a ^ 0 = a), leaving the single number.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SingleNumber {

    /**
     * Returns the element that appears only once.
     *
     * @param nums array in which every element but one appears twice
     * @return the unique element
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

}
