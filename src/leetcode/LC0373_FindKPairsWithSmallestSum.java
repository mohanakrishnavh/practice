package leetcode;

import java.util.*;

/**
 * LeetCode Problem 373: Find K Pairs with Smallest Sums
 * Difficulty: Medium
 * 
 * <p>Find k pairs with the smallest sums.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0373_FindKPairsWithSmallestSum {
    // TODO: Time Limit Exceeded - Need to come up with optimal solution
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<List<Integer>> pairs = new LinkedList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> sum(b) - sum(a));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                maxHeap.add(new int[]{nums1[i], nums2[j]});

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        while(!maxHeap.isEmpty()) {
            int[] pair = maxHeap.poll();
            pairs.addFirst(new ArrayList<>(Arrays.asList(pair[0], pair[1])));
        }

        return pairs;
    }

    private int sum(int[] nums) {
        return nums[0] + nums[1];
    }
}
