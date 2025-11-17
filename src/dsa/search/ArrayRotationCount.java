package dsa.search;

/**
 * ArrayRotationCount
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ArrayRotationCount {
    private static int findMin(int[] nums) {
        int N = nums.length;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            if (nums[start] <= nums[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % N;
            int prev = (mid + N - 1) % N;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int findMin2(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] <= nums[high]) {
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                high = mid - 1;
            } else {
                if (nums[low] < min) {
                    min = nums[low];
                }
                low = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{10, 11, 12, 15, 18, 2, 5, 6, 8}));
    }
}
