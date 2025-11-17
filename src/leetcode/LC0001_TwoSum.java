package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem 1: Two Sum
 * Difficulty: Easy
 * 
 * <p>Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * <p>You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 * 
 * <p>You can return the answer in any order.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>2 <= nums.length <= 10^4</li>
 *   <li>-10^9 <= nums[i] <= 10^9</li>
 *   <li>-10^9 <= target <= 10^9</li>
 *   <li>Only one valid answer exists.</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the length of the array
 * <p>Space Complexity: O(n) for the HashMap storage
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0001_TwoSum {
    
    /**
     * Finds two numbers in the array that add up to the target sum.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Use a HashMap to store each number and its index as we iterate</li>
     *   <li>For each number, calculate the complement (target - current number)</li>
     *   <li>Check if the complement exists in the HashMap</li>
     *   <li>If found, return the indices of both numbers</li>
     *   <li>If not found, add the current number to the HashMap and continue</li>
     * </ol>
     * 
     * <p>This approach is more efficient than the brute force O(n^2) nested loop approach.
     * 
     * @param nums   the array of integers to search
     * @param target the target sum to find
     * @return an array containing the indices of the two numbers that add up to target,
     *         or [-1, -1] if no solution exists
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (indexMap.containsKey(difference)) {
                return new int[]{i, indexMap.get(difference)};
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
