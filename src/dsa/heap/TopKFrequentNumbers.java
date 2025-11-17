package dsa.heap;

import dsa.util.FrequencyUtil;

import java.util.*;

/**
 * Top K Frequent Numbers Problem
 * 
 * <p>Given an array of integers and a number k, find the k most frequent numbers in the array.
 * 
 * <p>Problem: Find the k numbers that appear most frequently in the given array.
 * If multiple numbers have the same frequency, any of them can be returned.
 * 
 * <p>Example:
 * <pre>
 * Input: nums = [1, 1, 1, 3, 2, 2, 4], k = 2
 * Output: [1, 2]
 * Explanation: 1 appears 3 times, 2 appears 2 times, 3 appears 1 time, 4 appears 1 time.
 * The top 2 frequent numbers are 1 and 2.
 * </pre>
 * 
 * <p>Approach:
 * <ol>
 *   <li>Count frequency of each number using a HashMap</li>
 *   <li>Use a min heap of size k to track k most frequent numbers</li>
 *   <li>Heap stores pairs of [frequency, number]</li>
 *   <li>If heap size exceeds k, remove the element with minimum frequency</li>
 *   <li>Extract all numbers from the heap to get the result</li>
 * </ol>
 * 
 * <p>Time Complexity: O(n log k) where n is the array length
 * <ul>
 *   <li>O(n) to count frequencies</li>
 *   <li>O(n log k) to process all elements with heap of size k</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) for the frequency map and O(k) for the heap
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class TopKFrequentNumbers {
    
    /**
     * Finds the k most frequent numbers in the given array.
     * 
     * <p>This method uses a min heap approach to efficiently find the top k frequent
     * elements without sorting all frequencies.
     * 
     * @param nums the input array of integers
     * @param k    the number of most frequent elements to find
     * @return an array containing the k most frequent numbers
     */
    public static int[] getTopKFrequentNumbers(int[] nums, int k) {
        int[] topKFrequentNumbers = new int[k];

        Map<Integer, Integer> countMap = FrequencyUtil.getCountMap(nums);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int idx = 0;
        while(!minHeap.isEmpty()) {
            topKFrequentNumbers[idx++] = minHeap.poll()[1];
        }

        return topKFrequentNumbers;
    }

    /**
     * Main method to demonstrate finding top k frequent numbers.
     * 
     * <p>Test case: nums = [1, 1, 1, 3, 2, 2, 4], k = 2
     * <p>Expected output: [1, 2] (1 appears 3 times, 2 appears 2 times)
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTopKFrequentNumbers(new int[]{1, 1, 1, 3, 2, 2, 4}, 2)));
    }
}
