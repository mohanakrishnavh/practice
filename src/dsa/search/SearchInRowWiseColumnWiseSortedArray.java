package dsa.search;

import java.util.Arrays;

/**
 * SearchInRowWiseColumnWiseSortedArray
 *
 * <p>Searches a matrix in which every row is sorted left-to-right and every column is sorted top-to-bottom, e.g.
 * <pre>
 *   10 20 30 40
 *   15 25 35 45
 *   27 29 37 48
 *   32 33 39 50
 * </pre>
 *
 * <p><b>Idea (staircase search):</b> start at the <b>top-right</b> corner. That cell is the largest in its row and the
 * smallest in its column, so every comparison eliminates a whole row or a whole column:
 * <ul>
 *   <li>{@code target < cell} → everything below it in this column is even larger, so discard the column ({@code j--}).</li>
 *   <li>{@code target > cell} → everything left of it in this row is even smaller, so discard the row ({@code i++}).</li>
 * </ul>
 * (The bottom-left corner works symmetrically; top-left and bottom-right do not, as both directions would increase or
 * decrease together.)
 *
 * <p><b>Complexity:</b> Time O(rows + cols), Space O(1). It is not a binary search, but it exploits the same
 * "discard what can't contain the target" idea.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SearchInRowWiseColumnWiseSortedArray {
    /**
     * Returns the position of {@code target} in the matrix.
     *
     * @param matrix matrix with rows and columns sorted in ascending order
     * @param target value to find
     * @return {@code {row, column}} of the target, or {@code {-1, -1}} if it is not found
     */
    public static int[] search(int[][] matrix, int target) {
        // Empty matrix (or empty rows): nothing to search
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        // Start at the top-right corner
        int i = 0;
        int j = matrix[0].length - 1;

        // Stay inside the matrix: rows 0..length-1 (the last row is included), columns j >= 0
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            }

            if (target < matrix[i][j]) {
                // Target is smaller: this whole column (below the cell) is larger, move left
                j--;
            } else {
                // Target is larger: this whole row (left of the cell) is smaller, move down
                i++;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}}, 29))); // [2, 1]
        System.out.println(Arrays.toString(search(new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}}, 26))); // [-1, -1] (absent)
        System.out.println(Arrays.toString(search(new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}}, 50))); // [3, 3] (last row)
    }
}
