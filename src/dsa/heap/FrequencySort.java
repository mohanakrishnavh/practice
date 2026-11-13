package dsa.heap;

import dsa.util.FrequencyUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * FrequencySort
 * 
 * Sorts an array by element frequency using a max heap.
 *
 * <p>Problem: Given an array of integers, reorder it so that numbers with a higher
 * frequency appear first, with all occurrences of a number grouped together.
 *
 * <p>Example:
 * <pre>
 * Input:  [2, 2, 4, 3, 1, 1, 1]
 * Output: 1 appears 3 times, 2 appears 2 times, then 4 and 3 once each
 * </pre>
 *
 * <p>Approach:
 * <ol>
 *   <li>Count the frequency of each number with a HashMap</li>
 *   <li>Push [frequency, number] pairs into a max heap ordered by frequency</li>
 *   <li>Poll pairs and write each number to the output as many times as its frequency</li>
 * </ol>
 *
 * <p>Time Complexity: O(n + d log d) where n is the array length and d the number of distinct values
 * <p>Space Complexity: O(d) for the frequency map and heap, plus O(n) for the output
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FrequencySort {
    /**
     * Returns a new array with the elements ordered by descending frequency.
     *
     * @param nums the input array of integers
     * @return a new array of the same length sorted by frequency (highest first);
     *         an empty array if the input is empty
     */
    public static int[] sort(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> countMap = FrequencyUtil.getCountMap(nums);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxHeap.add(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] frequencySortedNums = new int[nums.length];
        int idx = 0;
        while (maxHeap.size() > 0) {
            int[] frequencyNumberPair = maxHeap.poll();
            int frequency = frequencyNumberPair[0];

            while (frequency > 0) {
                frequencySortedNums[idx++] = frequencyNumberPair[1];
                frequency--;
            }
        }

        return frequencySortedNums;
    }

    /**
     * Main method to demonstrate frequency sorting.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 2, 4, 3, 1, 1, 1})));
    }
}
