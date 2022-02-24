package dsa.search;

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

    public static void main(String[] args) {
        System.out.println(ArrayRotationCount.findMin(new int[]{10, 11, 12, 15, 18, 2, 5, 6, 8}));
    }
}
