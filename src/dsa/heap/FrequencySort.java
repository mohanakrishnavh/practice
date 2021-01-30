package dsa.heap;

import dsa.util.FrequencyUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {


    public static int[] sort(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> countMap = FrequencyUtil.getCountMap(nums);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : b[0]-a[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxHeap.add(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] frequencySortedNums = new int[nums.length];
        int index = 0;
        while (maxHeap.size() > 0) {
            int[] frequencyNumberPair = maxHeap.poll();
            int frequency = frequencyNumberPair[0];

            while (frequency > 0) {
                frequencySortedNums[index++] = frequencyNumberPair[1];
                frequency--;
            }
        }

        return frequencySortedNums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FrequencySort.sort(new int[]{2, 2, 4, 3, 1, 1, 1})));
    }
}
