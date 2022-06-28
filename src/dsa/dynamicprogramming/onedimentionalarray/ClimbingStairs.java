package dsa.dynamicprogramming.onedimentionalarray;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev = 1;
        int prev2 = 1;
        for (int i = 2 ; i <= n; i++) {
            int result = prev + prev2;

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
