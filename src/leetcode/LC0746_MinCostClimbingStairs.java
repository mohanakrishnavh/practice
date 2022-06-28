package leetcode;

public class LC0746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = 2; i <= cost.length; i++) {
            int result = Math.min(one + cost[i-1], two + cost[i-2]);
            two = one;
            one = result;
        }

        return one;
    }
}
