package dsa.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix
 * 
 * Traverses an m x n matrix in spiral order: left to right along the top, down the right
 * side, right to left along the bottom, then up the left side, working inwards (LeetCode 54).
 *
 * <p>Four boundaries (top, bottom, left, right) shrink after each side is traversed. The total
 * element count is used to stop early, which avoids duplicates when a single row or column remains.
 *
 * <p>Time complexity: O(m * n). Space complexity: O(1) beyond the output.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SpiralMatrix {

    /**
     * Returns the matrix elements in spiral order.
     *
     * @param matrix the input matrix
     * @return the elements in spiral order (empty list if the matrix is null or empty)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return spiralList;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while (spiralList.size() < size) {
            for (int j = left; j <= right && spiralList.size() < size; j++) {
                spiralList.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom && spiralList.size() < size; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;

            for (int j = right; j >= left && spiralList.size() < size; j--) {
                spiralList.add(matrix[bottom][j]);
            }
            bottom--;

            for (int i = bottom; i >= top && spiralList.size() < size; i--) {
                spiralList.add(matrix[i][left]);
            }
            left++;
        }

        return spiralList;
    }
}
