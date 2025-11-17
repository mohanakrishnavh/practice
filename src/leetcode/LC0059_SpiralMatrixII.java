package leetcode;

/**
 * LeetCode Problem 59: Spiral Matrix II
 * Difficulty: Medium
 * 
 * <p>Generate an n x n matrix filled with elements from 1 to n² in spiral order.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0059_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int counter = 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right ; j++) {
                matrix[top][j] = counter++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = counter++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = counter++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = counter++;
            }
            left++;
        }

        return matrix;
    }
}
