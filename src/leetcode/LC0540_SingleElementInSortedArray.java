package leetcode;

public class LC0540_SingleElementInSortedArray {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        // If there is only one element in the array
        if (n == 1) {
            return arr[0];
        }

        // If the first element is the single element
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // If the last element is the single element
        if (arr[n-2] != arr[n-1]) {
            return arr[n-1];
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low)/2;

            // Found the Single Element
            if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // Eliminating half of the search space
            // Checking if we are in the left half
            if ((mid % 2 == 1 && arr[mid-1] == arr[mid]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
