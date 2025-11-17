package leetcode;

import java.util.*;

/**
 * LeetCode Problem 692: Top K Frequent Words
 * Difficulty: Medium
 * 
 * <p>Return the k most frequent words.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) == frequencyMap.get(b) ? b.compareTo(a) : frequencyMap.get(a) - frequencyMap.get(b));
        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        LinkedList<String> topKFrequentWords = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            topKFrequentWords.addFirst(minHeap.poll());
        }

        return topKFrequentWords;
    }
}
