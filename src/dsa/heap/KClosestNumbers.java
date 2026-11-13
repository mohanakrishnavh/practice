package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * KClosestNumbers
 * 
 * Finds the k numbers closest to a target value x using a max heap.
 *
 * <p>Problem: Given an array of numbers, a count k and a target x, return the k numbers
 * whose absolute difference from x is smallest.
 *
 * <p>Example:
 * <pre>
 * Input: nums = [5, 6, 6, 7, 8, 9], k = 4, x = 7
 * Output: the four numbers closest to 7, i.e. 6, 6, 7, 8
 * </pre>
 *
 * <p>Approach: Keep a max heap of size k holding [distance, number] pairs ordered by distance.
 * After inserting each element, if the heap holds more than k pairs, evict the one that is
 * farthest from x. The k pairs that remain are the closest numbers.
 *
 * <p>Time Complexity: O(n log k)
 * <p>Space Complexity: O(k)
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KClosestNumbers {
    /**
     * Returns the k numbers in the array closest to x.
     *
     * @param nums the input array of integers
     * @param k    how many closest numbers to return
     * @param x    the target value to measure distance from
     * @return an array of k numbers closest to x, in heap polling order
     *         (farthest of the k first), not sorted by value
     */
    public static int[] getKClosestNumbers(int[] nums, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : b[0] - a[0]);
        for (int num : nums) {
            maxHeap.add(new int[]{Math.abs(x - num), num});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] kClosestNumbers = new int[k];
        int index = 0;
        while (maxHeap.size() > 0) {
            kClosestNumbers[index++] = maxHeap.poll()[1];
        }

        return kClosestNumbers;
    }

    /**
     * Main method to demonstrate finding the k closest numbers.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKClosestNumbers(new int[]{5, 6, 6, 7, 8, 9}, 4, 7)));
        System.out.println(Arrays.toString(getKClosestNumbers(new int[]{10, 2, 14, 4, 7, 6}, 3, 5)));
    }
}
