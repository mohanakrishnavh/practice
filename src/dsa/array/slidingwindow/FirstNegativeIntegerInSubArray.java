package dsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FirstNegativeIntegerInSubArray
 * 
 * Finds the first negative integer in every window of size {@code k} of an array using a
 * sliding window and a queue of the negatives currently inside the window.
 *
 * <p>The head of the queue is always the first negative of the current window. When the window
 * slides, the leaving element is dequeued if it is that head. A window with no negative yields 0.
 *
 * <p>Time complexity: O(n). Space complexity: O(k) for the queue.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FirstNegativeIntegerInSubArray {

    /**
     * Returns the first negative integer of each window of size {@code k}.
     *
     * @param arr the input array
     * @param k   the window size
     * @return one value per window: its first negative integer, or 0 if it has none
     * (empty list if the array is empty or {@code k} is 0)
     */
    public static List<Integer> getFirstNegativeInteger(int[] arr, int k) {
        List<Integer> firstNegatives = new ArrayList<>();

        // Empty array or k == 0: nothing to do (k > length also yields an empty list)
        if (arr.length == 0 || k == 0) {
            return firstNegatives;
        }

        // Window is [i, j]; the queue holds the window's negatives in order
        int i = 0, j = 0;
        Queue<Integer> negatives = new LinkedList<>();
        while (j < arr.length) {
            // Only negatives matter; zero and positives are ignored
            if (arr[j] < 0) {
                negatives.add(arr[j]);
            }

            // Window is full: answer, then slide
            if (j - i + 1 == k) {
                // Stays 0 if the window has no negative
                int firstNegative = 0;
                if (!negatives.isEmpty()) {
                    // Head = earliest negative in the window
                    firstNegative = negatives.peek();

                    // Drop it if it is leaving; a leaving negative is always the head,
                    // and a leaving non-negative never equals it
                    if (arr[i] == negatives.peek()) {
                        negatives.poll();
                    }
                }

                firstNegatives.add(firstNegative);
                i++;
            }

            j++;
        }

        return firstNegatives;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 3));
        System.out.println(getFirstNegativeInteger(new int[]{12, 1, 7, 8, -15, 30, 13, 28}, 3));
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 0));
        System.out.println(getFirstNegativeInteger(new int[]{}, 3));
    }
}
