package leetcode;

public class LC0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;

        if (size == 1) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) {
                return nums[0] > nums[1] ? 0 : 1;
            } else if (mid == size - 1) {
                return nums[size - 1] > nums[size - 2] ? size - 1 : size - 2;
            } else {
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }

                if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static int findPeakElement2(int[] arr) {
        int n = arr.length;

        // If there is only one element in the array
        if (n == 1) {
            return 0;
        }

        // If the first element is the peak element
        if (arr[0] > arr[1]) {
            return 0;
        }

        // If the last element is the peak element
        if (arr[n-1] > arr[n-2]) {
            return n-1;
        }

        int low = 1, high = n-2;
        while (low <= high) {
            int mid = low + (high - low)/2;

            // Peak Element
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If left half is the sorted half
            if (arr[mid - 1] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
