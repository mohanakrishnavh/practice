package leetcode;

/**
 * LeetCode Problem 746: Min Cost Climbing Stairs
 * Difficulty: Easy
 * 
 * <p>You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * 
 * <p>You can either start from the step with index 0, or the step with index 1.
 * 
 * <p>Return the minimum cost to reach the top of the floor.
 * 
 * <p>Example 1:
 * <pre>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>2 <= cost.length <= 1000</li>
 *   <li>0 <= cost[i] <= 999</li>
 * </ul>
 * 
 * <p>Dynamic Programming Approach:
 * To reach step i, you can come from step (i-1) or step (i-2). Choose the cheaper option.
 * dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
 * 
 * <p>Time Complexity: O(n) where n is the length of cost array
 * <p>Space Complexity: O(1) - uses only two variables
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0746_MinCostClimbingStairs {
    
    /**
     * Calculates the minimum cost to reach the top of the staircase.
     * 
     * <p>Uses space-optimized dynamic programming. At each step, we calculate
     * the minimum cost considering we can come from either of the previous two steps.
     * 
     * @param cost array where cost[i] is the cost of stepping on the ith step
     * @return the minimum cost to reach the top (beyond the last step)
     */
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = 2; i <= cost.length; i++) {
            int result = Math.min(one + cost[i-1], two + cost[i-2]);
            two = one;
            one = result;
        }

        return one;
    }
}
