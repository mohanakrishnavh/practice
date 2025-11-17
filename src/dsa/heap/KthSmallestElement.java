package dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Finds the Kth smallest element in an unsorted array using a max heap.
 * 
 * <p>Problem: Given an unsorted array and a number k, find the kth smallest element.
 * 
 * <p>Solution Approach:
 * Use a max heap of size k. The top of this heap will be the kth smallest element.
 * 
 * <p>Algorithm:
 * 1. Create a max heap to store k elements
 * 2. Iterate through the array:
 *    a. Add element to the heap
 *    b. If heap size exceeds k, remove the maximum element
 * 3. The top of the heap is the kth smallest element
 * 
 * <p>Why max heap?
 * By maintaining the k smallest elements in a max heap, the largest among
 * these k elements (at the top) is exactly the kth smallest element.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class KthSmallestElement {
    
    /**
     * Finds the kth smallest element in the array.
     * 
     * <p>Time Complexity: O(n log k) where n is array length and k is the parameter
     * - Each insertion takes O(log k)
     * - We do this for all n elements
     * 
     * <p>Space Complexity: O(k) for the max heap
     * 
     * @param nums the input array of integers
     * @param k the position of the smallest element to find (1-indexed)
     * @return the kth smallest element, or -1 if invalid input
     */
    public static int getKthSmallestElement(int[] nums, int k) {
        // Input validation
        if (nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }

        // Create a max heap using PriorityQueue with reverse comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.add(num);

            // Keep heap size at most k
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the largest element
            }
        }

        // The top of the max heap is the kth smallest element
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }

    /**
     * Main method to test the kth smallest element algorithm with various test cases.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test case 1: Normal case
        System.out.println("3rd smallest in [7, 10, 4, 3, 20, 15]: " + 
            getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3)); // Expected: 7
        
        // Test case 2: Empty array
        System.out.println("3rd smallest in []: " + 
            getKthSmallestElement(new int[]{}, 3)); // Expected: -1
        
        // Test case 3: K greater than array length
        System.out.println("100th smallest in [7, 10, 4, 3, 20, 15]: " + 
            getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 100)); // Expected: -1
        
        // Test case 4: Invalid k (negative)
        System.out.println("-1st smallest in [7, 10, 4, 3, 20, 15]: " + 
            getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, -1)); // Expected: -1
    }
}
