package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {

    /**
     * Sorts a k-sorted array
     *
     * Time Complexity : O(n log(k)) - n is the size of the array
     * Space Complexity : O(k) - k is the size of the heap
     *
     */
    public static int[] sort(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        int[] sortedNums = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        for (int i : nums) {
            minHeap.add(i);

            if (minHeap.size() > k) {
                sortedNums[index++] = minHeap.poll();
            }
        }

        while (minHeap.size() > 0) {
            sortedNums[index++] = minHeap.poll();
        }

        return sortedNums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(KSortedArray.sort(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));
    }
}
