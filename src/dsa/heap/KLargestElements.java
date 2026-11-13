package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * KLargestElements
 * 
 * Finds the k largest elements of an array using a min heap.
 *
 * <p>Problem: Given an array of numbers and an integer k, return the k largest numbers.
 *
 * <p>Example:
 * <pre>
 * Input: nums = [7, 10, 4, 3, 20, 15], k = 3
 * Output: [10, 15, 20]  (order may vary)
 * </pre>
 *
 * <p>Approach: Keep a min heap of size k. Add each number and, if the heap exceeds k,
 * remove the smallest. The numbers left in the heap are the k largest, and the heap
 * top is the kth largest.
 *
 * <p>Time Complexity: O(n log k)
 * <p>Space Complexity: O(k)
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KLargestElements {
    /**
     * Returns the k largest elements of the array.
     *
     * @param nums the input array of integers
     * @param k    how many of the largest elements to return
     * @return the k largest elements in heap order (not sorted), or null if the
     *         array is empty or k is not positive
     */
    public static Integer[] getKLargestElements(Integer[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Converting Priority Queue to Array
        // https://stackoverflow.com/questions/65306475/how-to-cast-object-into-int-in-java
        // return minHeap.toArray(Integer[]:new);
        return minHeap.toArray(new Integer[]{});
    }

    /**
     * Main method to demonstrate finding the k largest elements.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKLargestElements(new Integer[]{7, 10, 4, 3, 20, 15}, 3)));
    }
}
