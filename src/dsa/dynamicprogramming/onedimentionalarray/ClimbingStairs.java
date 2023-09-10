package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;
        int result;
        for (int i = 3; i <= n; i++) {
            result = first + second;

            first = second;
            second = result;
        }

        return second;
    }
}
