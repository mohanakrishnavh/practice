package leetcode;

import dsa.util.MathUtil;

/**
 * LeetCode Problem 724: Find Pivot Index
 * Difficulty: Easy
 * 
 * <p>Find the pivot index where left sum equals right sum.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0724_FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int pivotIndex = -1;
        int sum = MathUtil.sum(nums);
        int leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                pivotIndex = i;
                break;
            }

            leftSum += nums[i];
        }

        return pivotIndex;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1, -1, 0, 0, -1, -1}));
    }
}
