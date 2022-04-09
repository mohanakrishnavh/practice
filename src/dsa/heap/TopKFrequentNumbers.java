package dsa.heap;

import java.util.*;

public class TopKFrequentNumbers {
  public static List<Integer> getTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topKFrequentNumbers = new ArrayList<>();
    if (nums == null || nums.length <= 1 || k == 0) {
      return topKFrequentNumbers;
    }

    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      int[] frequencyNumberPair = new int[]{entry.getValue(), entry.getKey()};
      if (minHeap.size() < k) {
        minHeap.offer(frequencyNumberPair);
      } else {
        if (frequencyNumberPair[0] > minHeap.peek()[0]) {
          minHeap.offer(frequencyNumberPair);
          minHeap.poll();
        }
      }
    }

    while (!minHeap.isEmpty()) {
      topKFrequentNumbers.add(minHeap.poll()[1]);
    }

    return topKFrequentNumbers;
  }

  public static void main(String[] args) {
    System.out.println(getTopKFrequentNumbers(new int[]{1, 1, 1, 3, 2, 2, 4}, 2));
  }
}
