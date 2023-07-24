package dsa.dynamicprogramming.onedimentionalarray;

public class HouseRobberII {
    public static int rob(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int[] excludingFirst = excludeIndex(arr, 0);
        int[] excludingLast = excludeIndex(arr, arr.length - 1);

        return Math.max(robHelper(excludingFirst), robHelper(excludingLast));
    }

    private static int[] excludeIndex(int[] arr, int excludeIndex) {
        int[] excludedArr = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != excludeIndex) {
                excludedArr[idx++] = arr[i];
            }
        }

        return excludedArr;
    }

    private static int robHelper(int[] arr) {
        int n = arr.length;

        int prev = arr[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = i > 1 ? arr[i] + prev2 : arr[i];
            int notTake = prev;

            int result = Math.max(take, notTake);

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
