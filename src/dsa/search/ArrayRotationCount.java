package dsa.search;

public class ArrayRotationCount {
    private static int findMin(int[] arr) {
        int N = arr.length;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            if (arr[start] <= arr[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % N;
            int prev = (mid + N - 1) % N;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ArrayRotationCount.findMin(new int[]{10, 11, 12, 15, 18, 2, 5, 6, 8}));
    }
}
