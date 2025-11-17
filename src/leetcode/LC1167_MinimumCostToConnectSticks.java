package leetcode;

import java.util.PriorityQueue;

/**
 * LeetCode Problem 1167: Minimum Cost to Connect Sticks
 * Difficulty: Medium
 * 
 * <p>Find the minimum cost to connect all sticks.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC1167_MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int stick : sticks) {
            priorityQueue.add(stick);
        }

        int totalCost = 0;
        int cost = 0;
        while (priorityQueue.size() >= 2) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            cost = first + second;
            totalCost += cost;
            priorityQueue.add(cost);
        }

        return totalCost;
    }
}
