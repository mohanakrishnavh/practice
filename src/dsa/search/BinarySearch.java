package dsa.search;

/**
 * BinarySearch
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BinarySearch {
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int searchRecursive(int[] arr, int target) {
        return searchRecursive(arr, 0, arr.length - 1, target);
    }

    public static int searchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;
        if (arr[mid] == target) {
            return mid;
        }

        if (target > arr[mid]) {
            BinarySearch.searchRecursive(arr, mid + 1, high, target);
        }

        return BinarySearch.searchRecursive(arr, 0, mid - 1, target);
    }

    public static int search(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100));
        System.out.println(searchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(searchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100));
    }
}
