package dsa.dp.knapsack;

public class EqualSumPartition {
    public static boolean hasEqualSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return SubsetSum.hasSubsetSum(nums, sum / 2);
    }

    public static void main(String[] args) {
        System.out.println(hasEqualSum(new int[]{1, 5, 11, 5}));
        System.out.println(hasEqualSum(new int[]{1, 11, 5, 2}));
    }
}
