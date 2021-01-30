package dsa.dynamicprogramming;

public class EqualSumPartition {
    public static boolean hasEqualSum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return SubsetSum.hasSubsetSum(arr, sum / 2);
    }

    public static void main(String[] args) {
        System.out.println(EqualSumPartition.hasEqualSum(new int[]{1, 5, 11, 5}));
        System.out.println(EqualSumPartition.hasEqualSum(new int[]{1, 11, 5, 2}));
    }
}
