package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0054_SpiralMatrix {

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
