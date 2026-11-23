package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix
 * 
 * Returns the elements of a matrix in spiral order.
 *
 * <p>Approach: Maintain four boundaries (top, bottom, left, right) and traverse right, down,
 * left, up, shrinking the boundaries after each side. Traversal stops once every element has
 * been added, which guards against double-visiting on non-square matrices.
 *
 * <p>Time Complexity: O(rows * cols). Space Complexity: O(1) beyond the output.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SpiralMatrix {
    /**
     * Returns the matrix elements in clockwise spiral order.
     *
     * @param matrix the input matrix
     * @return the elements in spiral order, or an empty list for a null or empty matrix
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(SpiralMatrix.spiralOrder(matrix));
    }
}
