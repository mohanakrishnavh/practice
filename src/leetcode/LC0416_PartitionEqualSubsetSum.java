package leetcode;

public class LC0416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return hasSubsetSum(arr, sum/2);
    }

    public static boolean hasSubsetSum(int[] arr, int k) {
        boolean[] previous = new boolean[k+1];
        previous[0] = true;

        if (arr[0] <= k) {
            previous[arr[0]] = true;
        }

        for (int index = 1; index < arr.length; index++) {
            boolean[] current = new boolean[k+1];
            current[0] = true;

            for (int target = 1; target <= k; target++) {
                boolean notTake = previous[target];
                boolean take = false;
                if (arr[index] <= target) {
                    take = previous[target - arr[index]];
                }

                current[target] = take || notTake;
            }

            previous = current;
        }

        return previous[k];
    }
}
