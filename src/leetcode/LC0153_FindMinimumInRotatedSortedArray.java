package leetcode;

public class LC0153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int N = A.length;

        while (start <= end) {
            if (A[start] <= A[end]) {
                return A[start];
            }

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % N;
            int previous = (mid + N - 1) % N;

            if (A[previous] >= A[mid] && A[mid] <= A[next]) {
                return A[mid];
            }

            if (A[start] <= A[mid]) {
                start = mid + 1;
            } else if (A[mid] <= A[end]) {
                end = mid - 1;
            }
        }

        return 0;
    }

    public static int findMin2(int[] arr) {
        int low = 0; int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] <= arr[high]) {
                if (arr[mid] < min) {
                    min = arr[mid];
                }
                high = mid - 1;
            } else {
                if (arr[low] < min) {
                    min = arr[low];
                }
                low = mid + 1;
            }
        }

        return min;
    }
}
