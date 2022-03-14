package dsa.search;

public class CeilOfAnElement {
    public static int getCeil(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ceil = nums[mid];
                end = mid - 1;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(getCeil(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5));
        System.out.println(getCeil(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 4));
    }
}
