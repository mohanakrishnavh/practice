package leetcode;

/**
 * LeetCode Problem 1351: Count Negative Numbers in a Sorted Matrix
 * Difficulty: Easy
 * 
 * <p>Count negative numbers in a sorted matrix.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC1351_CountNegativeNumberInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            count += getRowNegativeCount(row);
        }

        return count;
    }

    private int getRowNegativeCount(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int firstNegative = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] < 0) {
                firstNegative = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return firstNegative == -1 ? 0 : (nums.length - firstNegative);
    }
}
