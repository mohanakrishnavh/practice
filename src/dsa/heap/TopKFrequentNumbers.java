package dsa.heap;

import dsa.util.FrequencyUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
    public static int[] getTopKFrequentNumbers(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        Map<Integer, Integer> countMap = FrequencyUtil.getCountMap(nums);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topKFrequentNumbers = new int[k];
        int index = 0;
        while (minHeap.size() > 0) {
            topKFrequentNumbers[index++] = minHeap.poll()[1];
        }

        return topKFrequentNumbers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTopKFrequentNumbers(new int[]{1, 1, 1, 3, 2, 2, 4}, 2)));
    }
}
