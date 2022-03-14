package dsa.search;

public class MinimumDifferenceElement {
    // Approach 1 : Find the ceil and floor of the element
    // Return the min(ceil, floor) of the given element
    public static int getElementWithMinimumDifference(int[] nums, int key) {
        int ceil = CeilOfAnElement.getCeil(nums, key);
        int floor = FloorOfAnElement.getFloor(nums, key);

        return Math.min(ceil, floor);
    }

    // Approach 2 : Running the Binary Search
    // Case 1 : Element is present in the array, return the element
    // Case 2 : Element is not present in the array, return the min(abs(arr[start] - key), abs(arr[end] - key))
    public static int getElementWithMinimumDifferenceOptimized(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == key) {
                return nums[mid];
            }

            if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return Math.abs(nums[start] - key) <= Math.abs(nums[end] - key) ? nums[start] : nums[end];
    }

    public static void main(String[] args) {
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 7));
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 6));
        System.out.println(getElementWithMinimumDifferenceOptimized(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(getElementWithMinimumDifferenceOptimized(new int[]{1, 3, 8, 10, 12, 15}, 12));
    }
}
