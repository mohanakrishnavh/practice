package dsa.search;

public class ReverseBinarySearch {
    public static int search(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {
                return mid;
            }

            if (x < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ReverseBinarySearch.search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 9));
        System.out.println(ReverseBinarySearch.search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 25));
    }
}
