package leetcode;

/**
 * LeetCode Problem 1822: Sign of the Product of an Array
 * Difficulty: Easy
 * 
 * <p>Return the sign of the product of an array.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC1822_SignOfProductOfAnArray {
    public int arraySign(int[] nums) {
        boolean isZero = false;
        boolean isNegative = false;
        for (int num : nums) {
            if (num == 0) {
                isZero = true;
            } else if (num < 0) {
                isNegative = !isNegative;
            }
        }

        return isZero ? 0 : (isNegative ? -1 : 1);
    }
}
