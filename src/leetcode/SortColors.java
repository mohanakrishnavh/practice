package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int medium = 0;
        int high = nums.length-1;

        while (medium <= high) {
            if (nums[medium] == 0) {
                swap(nums, low, medium);
                low++;
                medium++;
            }

            else if (nums[medium] == 1) {
                medium++;
            }

            else if (nums[medium] == 2) {
                swap(nums, medium, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
