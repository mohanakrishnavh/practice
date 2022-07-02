package dsa.dynamicprogramming.subsequences;

import static dsa.dynamicprogramming.subsequences.SubsetSum.hasSubsetSum4;

public class EqualSumPartition {
    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return hasSubsetSum4(arr, sum/2);
    }
}
