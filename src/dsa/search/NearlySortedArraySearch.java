package dsa.search;

public class NearlySortedArraySearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (mid - 1 >= start && nums[mid - 1] == target) {
                return mid - 1;
            }

            if (mid + 1 <= end && nums[mid + 1] == target) {
                return mid + 1;
            }

            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {5, 10, 30, 20, 40}, 20));
    }
}
