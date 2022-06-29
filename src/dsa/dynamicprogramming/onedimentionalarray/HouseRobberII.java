package dsa.dynamicprogramming.onedimentionalarray;

public class HouseRobberII {
    public int houseRobber2(int[] nums) {
        int n = nums.length;
        int[] excludeFirst = new int[n-1];
        int[] excludeLast = new int[n-1];

        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                excludeFirst[first++] = nums[i];
            }

            if (i != nums.length-1) {
                excludeLast[second++] = nums[i];
            }
        }

        return Math.max(rob2(excludeFirst), rob2(excludeLast));
    }

    private int rob2(int[] nums) {
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
