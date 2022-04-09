package leetcode;

public class LC0416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = findSum(nums);

        if (sum % 2 != 0) {
            return false;
        }

        return hasSubsetSum(nums, sum / 2);
    }

    private int findSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    private boolean hasSubsetSum(int[] nums, int sum) {
        int i = 0, j = 0;
        boolean[][] t = new boolean[nums.length + 1][sum + 1];

        for (i = 0; i <= nums.length; i++) {
            t[i][j] = true;
        }

        for (i = 1; i <= nums.length; i++) {
            for (j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[nums.length][sum];
    }
}
