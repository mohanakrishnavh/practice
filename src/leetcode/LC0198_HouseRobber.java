package leetcode;

public class LC0198_HouseRobber {
    public int rob(int[] nums) {
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
