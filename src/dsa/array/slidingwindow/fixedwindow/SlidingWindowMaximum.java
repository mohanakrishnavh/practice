package dsa.array.slidingwindow.fixedwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * SlidingWindowMaximum
 * 
 * Finds the maximum of every window of size {@code k} as it slides across an array (LeetCode 239).
 *
 * <p>A monotonic decreasing deque holds candidate maximums: smaller values at the back are discarded
 * when a larger value arrives, so the front of the deque is always the maximum of the current window.
 * The front is removed when it slides out of the window.
 *
 * <p>Time complexity: O(n). Space complexity: O(k).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SlidingWindowMaximum {
    /**
     * Returns the maximum value of each window of size {@code k}.
     *
     * @param nums the input array
     * @param k    the window size (must be between 1 and {@code nums.length})
     * @return array of {@code nums.length - k + 1} window maximums
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // One maximum per window; k must be in [1, nums.length] or this size is invalid
        int[] max = new int[nums.length - k + 1];
        int idx = 0;

        // Window is [i, j]; deque holds values in decreasing order, front = window max
        int i = 0, j = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (j < nums.length) {
            // Smaller values behind a larger newcomer can never be a max again, so drop them.
            // Strict '<' keeps equal values, so duplicates are each removed when they leave.
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }

            deque.addLast(nums[j]);

            // Window is full: the front is its max
            if (j - i + 1 == k) {
                max[idx++] = deque.peekFirst();

                // If the leaving element is the current max, remove it from the front
                if (nums[i] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                i++;
            }

            j++;
        }

        return max;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(List.of(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
