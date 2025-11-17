package dsa.dynamicprogramming.twodimentionalarray;

import java.util.Arrays;

/**
 * Ninja Training Problem (2D DP).
 * 
 * <p>A ninja has N days of training. Each day, the ninja can perform one of three tasks,
 * and each task gives different points. However, the ninja cannot perform the same task
 * on consecutive days. Find the maximum points the ninja can earn.
 * 
 * <p>This is a 2D DP problem where:
 * - State: (day, lastTask) = maximum points from day onwards if lastTask was performed on previous day
 * - Transition: Try all tasks except lastTask and pick maximum
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion - O(3^n) time exponential</li>
 *   <li>Memoization - O(n*4) time, O(n*4) space</li>
 *   <li>Tabulation - O(n*4) time, O(n*4) space</li>
 * </ul>
 * 
 * <p>Example: For points [[1,2,5], [3,1,1], [3,3,3]], max points = 11 (5+3+3)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class NinjaTraining {
    /**
     * Finds maximum points using recursion.
     * 
     * <p>Time Complexity: O(3^n) - Exponential
     * <p>Space Complexity: O(n) - Recursion stack
     * 
     * @param points 2D array of points for each task on each day
     * @return maximum points achievable
     */
    public static int maxPoints(int[][] points) {
        return maxPoints(points.length - 1, 3, points);
    }

    /**
     * Helper method for recursive calculation.
     * 
     * @param day current day
     * @param last last task performed (3 means no task performed yet)
     * @param points 2D array of points
     * @return maximum points from current day onwards
     */
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

    /**
     * Finds maximum points using memoization (Top-Down DP).
     * 
     * <p>Time Complexity: O(n*4*3) = O(n) - Each state computed once
     * <p>Space Complexity: O(n*4) - DP table + recursion stack
     * 
     * @param points 2D array of points for each task on each day
     * @return maximum points achievable
     */
    public static int maxPoints2(int[][] points) {
        int[][] dp = new int[points.length][points[0].length + 1];
        for (int i = 0; i < points.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxPoints2(points.length - 1, 3, points, dp);
    }

    /**
     * Helper method for memoized calculation.
     * 
     * @param day current day
     * @param last last task performed
     * @param points 2D array of points
     * @param dp memoization table
     * @return maximum points from current day onwards
     */
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

    /**
     * Finds maximum points using tabulation (Bottom-Up DP).
     * 
     * <p>Builds DP table iteratively from base cases to final answer.
     * 
     * <p>Time Complexity: O(n*4*3) = O(n)
     * <p>Space Complexity: O(n*4) - DP table
     * 
     * @param points 2D array of points for each task on each day
     * @return maximum points achievable
     */
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
