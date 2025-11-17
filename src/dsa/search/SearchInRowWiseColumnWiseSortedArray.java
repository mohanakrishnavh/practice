package dsa.search;

import java.util.Arrays;

/**
 * SearchInRowWiseColumnWiseSortedArray
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SearchInRowWiseColumnWiseSortedArray {
    public static int[] search(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && i < matrix.length - 1 && j >= 0 && j <= matrix[i].length) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            }

            if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}}, 29)));
        System.out.println(Arrays.toString(search(new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}}, 26)));
    }
}
