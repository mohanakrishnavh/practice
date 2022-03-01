package dsa.dynamicprogramming.knapsack;

public class CountOfSubsetSum {
    public static int subsetSumCount(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(CountOfSubsetSum.subsetSumCount(new int[]{2, 3, 5, 6, 8, 10}, 10));
    }
}
