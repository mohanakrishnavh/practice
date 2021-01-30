package dsa.search;

public class OrderAgnosticSearch {
    public static int search(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        if (arr[start] == arr[end]) {
            if (x == arr[start]) {
                return 0;
            }
        } else if (arr[start] < arr[end]) {
            return BinarySearch.search(arr, x);
        } else {
            return ReverseBinarySearch.search(arr, x);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 3, 5, 10, 12, 13}, 12));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 3, 5, 10, 12, 13}, 100));
        System.out.println(OrderAgnosticSearch.search(new int[]{100, 30, 5, 4, 3, 1}, 100));
        System.out.println(OrderAgnosticSearch.search(new int[]{100, 30, 5, 4, 3, 1}, -1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, -1));
    }
}
