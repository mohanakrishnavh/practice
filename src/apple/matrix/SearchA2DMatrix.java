package apple.matrix;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
