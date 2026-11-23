package dsa.matrix;

/**
 * SearchA2DMatrix
 * 
 * Searches for a target in a matrix whose rows are sorted and where the first element of each
 * row is greater than the last element of the previous row (LeetCode 74).
 *
 * <p>The row that could contain the target is located by scanning row bounds, then a binary
 * search is run within that row.
 *
 * <p>Time complexity: O(m + log n) for an m x n matrix. Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SearchA2DMatrix {
    /**
     * Returns whether {@code target} exists in the matrix.
     *
     * @param matrix matrix with sorted rows, each row starting above the previous row's last value
     * @param target value to search for
     * @return true if the target is present, false otherwise
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1}}, 0));
    }
}
