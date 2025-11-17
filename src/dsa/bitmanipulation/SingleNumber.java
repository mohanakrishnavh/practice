package dsa.bitmanipulation;

/**
 * SingleNumber
 * 
 * <p>This class provides a solution to find the single number in an array where every
 * element appears twice except for one element. Uses the XOR bitwise operation which has
 * the property that a ⊕ a = 0 and a ⊕ 0 = a, making duplicate numbers cancel each other out.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SingleNumber {
    /**
     * Finds the single number that appears only once in an array where all other numbers appear twice.
     * 
     * <p>Uses XOR operation properties:
     * - XOR of a number with itself is 0 (a ⊕ a = 0)
     * - XOR of a number with 0 is the number itself (a ⊕ 0 = a)
     * - XOR is commutative and associative
     * 
     * <p>Since all duplicate numbers will XOR to 0, only the single number remains.
     * 
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(1)
     * 
     * @param nums an array of integers where every element appears twice except one
     * @return the single number that appears only once
     * 
     * @example
     * Input: [2, 1, 2, 5, 6, 5, 7, 7, 6]
     * Output: 1
     * Explanation: 2⊕1⊕2⊕5⊕6⊕5⊕7⊕7⊕6 = (2⊕2)⊕(5⊕5)⊕(6⊕6)⊕(7⊕7)⊕1 = 0⊕0⊕0⊕0⊕1 = 1
     */
    public static int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single = single ^ num;
        }

        return single;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 1, 2, 5, 6, 5, 7, 7, 6}));
    }
}
