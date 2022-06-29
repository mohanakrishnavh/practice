package dsa.dynamicprogramming.twodimentionalarray;

import java.util.Arrays;

public class NinjaTraining {
    // Approach 1 : Recursion
    public static int maxPoints(int[][] points) {
        return maxPoints(points.length - 1, 3, points);
    }

    private static int maxPoints(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < points[0].length; task++) {
                max = Math.max(max, points[0][task]);
            }

            return max;
        }

        int max = 0;
        for (int task = 0; task < points[0].length; task++) {
            if (task != last) {
                int point = points[day][task] + maxPoints(day-1, task, points);
                max = Math.max(point, max);
            }
        }

        return max;
    }

    // Approach 2 : Memoization
    public static int maxPoints2(int[][] points) {
        int[][] dp = new int[points.length][points[0].length + 1];
        for (int i = 0; i < points.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxPoints2(points.length - 1, 3, points, dp);
    }

    private static int maxPoints2(int day, int last, int[][] points, int[][]dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        if (day == 0) {
            int max = 0;
            for (int task = 0; task < points[0].length; task++) {
                max = Math.max(max, points[0][task]);
            }

            dp[day][last] = max;
            return max;
        }

        int max = 0;
        for (int task = 0; task < points[0].length; task++) {
            if (task != last) {
                int point = points[day][task] + maxPoints(day-1, task, points);
                max = Math.max(point, max);
            }
        }

        dp[day][last] = max;
        return max;
    }


    // Approach 3 : Top-Down
    public static int maxPoints3(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < points.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Initializing the base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(point, dp[day][last]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,2,5}, {3 ,1 ,1} ,{3,3,3}};
        System.out.println(maxPoints3(points));
    }
}
