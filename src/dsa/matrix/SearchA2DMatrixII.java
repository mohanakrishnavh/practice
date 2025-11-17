package dsa.matrix;

/**
 * SearchA2DMatrixII
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SearchA2DMatrixII {
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
