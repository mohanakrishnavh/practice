package dsa.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SortKSortedArray {
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));
        System.out.println(Arrays.toString(sortInDescendingOrder(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));
    }
}
