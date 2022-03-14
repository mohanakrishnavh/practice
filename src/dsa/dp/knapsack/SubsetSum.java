package dsa.dp.knapsack;

public class SubsetSum {
    public static boolean hasSubsetSum(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];

        int j = 0;
        for (int i = 0; i <= arr.length; i++) {
            t[i][j] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(hasSubsetSum(new int[]{2, 3, 7, 8, 10}, 11));
        System.out.println(hasSubsetSum(new int[]{2, 3, 7, 13, 10}, 11));
    }
}
