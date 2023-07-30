package dsa.heap;

import dsa.util.FrequencyUtil;

import java.util.*;

public class TopKFrequentNumbers {
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTopKFrequentNumbers(new int[]{1, 1, 1, 3, 2, 2, 4}, 2)));
    }
}
