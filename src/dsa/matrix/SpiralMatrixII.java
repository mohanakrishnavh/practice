package dsa.matrix;

/**
 * SpiralMatrixII
 * 
 * Generates an n x n matrix filled with the numbers 1 to n^2 in spiral order (LeetCode 59).
 *
 * <p>Uses the same shrinking top/bottom/left/right boundaries as {@link SpiralMatrix}, writing an
 * incrementing counter instead of reading values.
 *
 * <p>Time complexity: O(n^2). Space complexity: O(1) beyond the output.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SpiralMatrixII {

    /**
     * Builds the spiral matrix.
     *
     * @param n the matrix dimension (n x n)
     * @return the matrix with 1 to n^2 laid out in a clockwise spiral
     */
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
