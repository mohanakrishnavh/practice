package dsa.matrix;

/**
 * SearchA2DMatrixII
 * 
 * Searches for a target in a matrix whose rows and columns are each sorted in ascending order (LeetCode 240).
 *
 * <p>Uses the "staircase" search from the top-right corner: if the current value is larger than the
 * target, move left; otherwise move down. Each step discards a row or a column.
 *
 * <p>Time complexity: O(m + n). Space complexity: O(1).
 * Note: the loop condition stops before the last row ({@code i < matrix.length - 1}), so a target
 * located only in the last row can be missed.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SearchA2DMatrixII {
    /**
     * Returns whether {@code target} exists in the matrix.
     *
     * @param matrix matrix with rows and columns sorted in ascending order
     * @param target value to search for
     * @return true if the target is found, false otherwise
     */
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
