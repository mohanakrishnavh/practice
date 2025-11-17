package leetcode;

/**
 * LeetCode Problem 240: Search a 2D Matrix II
 * Difficulty: Medium
 * 
 * <p>Search in a 2D matrix where rows and columns are sorted.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && i < matrix.length - 1 && j >= 0 && j <= matrix[i].length) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
