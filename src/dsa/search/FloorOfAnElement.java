package dsa.search;

public class FloorOfAnElement {
    public static int getFloor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int floor = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }

            if (nums[mid] < target) {
                floor = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return floor;
    }

    public static void main(String[] args) {
        System.out.println(getFloor(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5));
        System.out.println(getFloor(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 4));
    }
}
