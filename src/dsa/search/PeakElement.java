package dsa.search;

/**
 * PeakElement
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PeakElement {
    public static int getPeakElement(int[] nums) {
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

    public static int findPeakElement(int[] arr) {
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
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{5, 10, 20, 15}));
        System.out.println(findPeakElement(new int[]{10, 20, 15, 2, 23, 90, 67}));
        System.out.println(findPeakElement(new int[]{10, 20, 30, 40, 50}));
        System.out.println(findPeakElement(new int[]{50, 40, 30, 20, 10}));
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}
