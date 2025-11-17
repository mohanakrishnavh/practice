package leetcode;

/**
 * LeetCode Problem 72: Search a 2D Matrix
 * Difficulty: Medium
 * 
 * <p>Search for a value in an m x n matrix with sorted properties.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0072_SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[i].length - 1;

        // Find the row in which the element can exist
        while (i >= 0 && i <= matrix.length - 1) {
            if (matrix[i][0] <= target && target <= matrix[i][j]) {
                break;
            }

            i++;
        }

        // If the element is not present in the matrix
        if (i == matrix.length) {
            return false;
        }

        // Running Binary Search to find the element
        int row = i;
        int start = 0;
        int end = j;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1}}, 0));
    }
}
