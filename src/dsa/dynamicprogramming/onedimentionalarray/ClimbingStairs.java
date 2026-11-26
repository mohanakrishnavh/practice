package dsa.dynamicprogramming.onedimentionalarray;

/**
 * Climbing Stairs Problem (LeetCode 70).
 * 
 * <p>You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * <p><b>Idea:</b> the last move onto step {@code n} is either a 1-step from {@code n - 1} or a 2-step
 * from {@code n - 2}, so {@code ways(n) = ways(n - 1) + ways(n - 2)}, with base cases
 * {@code ways(1) = 1} and {@code ways(2) = 2}. This is the Fibonacci sequence shifted by one.
 * 
 * <p>Each value depends only on the two before it, so instead of a full DP table this
 * implementation keeps just the last two values: O(n) time, O(1) space.
 * 
 * <p>Example: For n=3, there are 3 ways: (1+1+1), (1+2), (2+1)
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ClimbingStairs {

    /**
     * Counts the distinct ways to climb {@code n} stairs taking 1 or 2 steps at a time.
     * 
     * <p>Space-optimized bottom-up DP: {@code first} and {@code second} hold {@code ways(i - 2)} and
     * {@code ways(i - 1)}; each iteration computes {@code ways(i)} and shifts the pair forward.
     * For {@code n <= 2} the answer equals {@code n} (1 way for 1 step, 2 ways for 2 steps).
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Only two variables
     * 
     * @param n number of stairs (LeetCode guarantees 1 &lt;= n &lt;= 45, so the result fits in an int)
     * @return number of distinct ways to climb to the top
     */
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

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] ns = {
                1,   // base case: (1)
                2,   // base case: (1+1), (2)
                3,   // (1+1+1), (1+2), (2+1)
                4,
                5,
                10,
                45,  // largest n allowed by LeetCode 70; the answer still fits in an int
        };
        int[] expected = {1, 2, 3, 5, 8, 89, 1836311903};

        ClimbingStairs solver = new ClimbingStairs();
        for (int t = 0; t < ns.length; t++) {
            int result = solver.climbStairs(ns[t]);
            System.out.println((result == expected[t] ? "PASS" : "FAIL") + " - n=" + ns[t]
                    + " (expected " + expected[t] + ", got " + result + ")");
        }
    }
}
