package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int k = sum / 2;

        boolean[] previous = new boolean[k + 1];
        previous[0] = true;

        if (arr[0] <= k) {
            previous[arr[0]] = true;
        }

        for (int index = 1; index < arr.length; index++) {
            boolean[] current = new boolean[k + 1];
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

        // The first true in the array will give us a subset sum equal to k
        int firstSubsetSum = previous.length - 1;
        while (!previous[firstSubsetSum]) {
            firstSubsetSum--;
        }


        return Math.abs(firstSubsetSum - (sum - firstSubsetSum));
    }
}
