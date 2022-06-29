package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];

        rob(nums.length-1, nums, dp);

        return dp[nums.length-1];
    }

    private int rob(int index, int[] nums, int[] dp) {
        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return nums[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + rob(index - 2, nums, dp);
        int notPick = rob(index - 1, nums, dp);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    public int rob2(int[] nums) {
        int n = nums.length;

        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = i > 1 ? nums[i] + prev2 : nums[i];
            int notTake = prev;

            int result = Math.max(take, notTake);

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
