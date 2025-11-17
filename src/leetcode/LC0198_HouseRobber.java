package leetcode;

/**
 * LeetCode Problem 198: House Robber
 * Difficulty: Medium
 * 
 * <p>You are a professional robber planning to rob houses along a street. Each house has
 * a certain amount of money stashed. The only constraint stopping you from robbing each
 * of them is that adjacent houses have security systems connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * 
 * <p>Given an integer array nums representing the amount of money of each house, return
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= nums.length <= 100</li>
 *   <li>0 <= nums[i] <= 400</li>
 * </ul>
 * 
 * <p>Dynamic Programming Approach:
 * At each house, you have two choices:
 * <ol>
 *   <li>Rob this house: add its value to the max from two houses ago</li>
 *   <li>Don't rob this house: take the max from the previous house</li>
 * </ol>
 * dp[i] = max(nums[i] + dp[i-2], dp[i-1])
 * 
 * <p>Time Complexity: O(n) where n is the number of houses
 * <p>Space Complexity: O(1) - space optimized using two variables
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0198_HouseRobber {
    
    /**
     * Calculates the maximum amount of money that can be robbed without robbing adjacent houses.
     * 
     * <p>Uses space-optimized dynamic programming to track only the previous two states.
     * 
     * @param nums array where nums[i] represents the amount of money in house i
     * @return the maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        int n = nums.length;

        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = i > 1 ? nums[i] + prev2 : nums[i];
            int notTake = prev;

            int result = Math.max(take, notTake);

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
