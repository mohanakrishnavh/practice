package leetcode;

/**
 * LeetCode Problem 136: Single Number
 * Difficulty: Easy
 * 
 * <p>Find the element that appears only once while others appear twice.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0136_SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;

        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }

        return single;
    }
}
