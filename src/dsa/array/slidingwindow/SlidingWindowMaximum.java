package dsa.array.slidingwindow;

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
        int left = 0, right = 0, idx = 0;
        int[] max = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        while (right < nums.length) {
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(nums[right]);

            if (right - left + 1 == k) {
                max[idx++] = deque.peekFirst();

                if (nums[left] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                left++;
            }
            right++;
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
