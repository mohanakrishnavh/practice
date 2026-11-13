package dsa.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * SortKSortedArray
 * 
 * Sorts a k-sorted array using a heap.
 *
 * <p>Problem: A k-sorted array is one where every element is at most k positions away from
 * its position in the fully sorted array. Sort it faster than a general O(n log n) sort.
 *
 * <p>Example:
 * <pre>
 * Input: nums = [6, 5, 3, 2, 8, 10, 9], k = 3
 * Output (ascending): [2, 3, 5, 6, 8, 9, 10]
 * </pre>
 *
 * <p>Approach: Keep a heap of the most recent elements. Once it holds more than k elements,
 * the top is guaranteed to be the next element of the sorted output, so poll it into the
 * result. After the input is consumed, drain the remaining heap into the result.
 *
 * <p>Time Complexity: O(n log k)
 * <p>Space Complexity: O(k) for the heap, plus O(n) for the output
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SortKSortedArray {
    /**
     * Sorts the array in ascending order using a min heap.
     *
     * @param nums the k-sorted input array
     * @param k    the maximum distance of any element from its sorted position
     * @return a new array in ascending order, or null if the array is empty or k is not positive
     */
    public static int[] sort(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        int[] result = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int idx = 0;
        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                result[idx++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll();
        }

        return result;
    }

    /**
     * Sorts the array in descending order using a max heap, scanning from the end of the array.
     *
     * @param nums the k-sorted input array
     * @param k    the maximum distance of any element from its sorted position
     * @return a new array in descending order, or null if the array is empty or k is not positive
     */
    public static int[] sortInDescendingOrder(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        int[] sortedNums = new int[nums.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            priorityQueue.add(nums[i]);

            if (priorityQueue.size() > k) {
                sortedNums[index++] = priorityQueue.poll();
            }
        }

        while (!priorityQueue.isEmpty()) {
            sortedNums[index++] = priorityQueue.poll();
        }

        return sortedNums;
    }

    /**
     * Main method to demonstrate sorting a k-sorted array in both orders.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));
        System.out.println(Arrays.toString(sortInDescendingOrder(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));
    }
}
