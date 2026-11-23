package dsa.greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    public int getAvgWaitTime(int[] arr) {
        Arrays.sort(arr);

        int time = 0, waitTime = 0;
        for (int j : arr) {
            waitTime += time;
            time += j;
        }

        return (waitTime/arr.length);
    }

    /**
     * Runs one test case and prints PASS or FAIL.
     *
     * @param name     a short description of the case
     * @param jobs     the job burst times
     * @param expected the expected average waiting time (integer division)
     */
    private static void check(String name, int[] jobs, int expected) {
        int actual = new ShortestJobFirst().getAvgWaitTime(jobs);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        // Sorted: 1 2 3 4 7 -> waits 0 1 3 6 10 = 20 -> 20 / 5 = 4
        check("unsorted jobs [4 3 7 1 2]", new int[]{4, 3, 7, 1, 2}, 4);
        check("already sorted", new int[]{1, 2, 3, 4, 7}, 4);
        check("single job waits 0", new int[]{5}, 0);
        check("equal jobs", new int[]{3, 3, 3}, 3);
        check("longest job first in input", new int[]{7, 1}, 0);
        check("average truncated by integer division", new int[]{1, 3, 4}, 1);

        // Empty input divides by zero in the current implementation
        try {
            new ShortestJobFirst().getAvgWaitTime(new int[]{});
            System.out.println("FAIL - empty input (expected ArithmeticException)");
        } catch (ArithmeticException e) {
            System.out.println("PASS - empty input throws ArithmeticException");
        }
    }
}
