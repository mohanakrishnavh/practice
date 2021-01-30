package leetcode.heap;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = getCountMap(words);
        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> countMap.get(w1).equals(countMap.get(w2)) ? w2.compareTo(w1) : countMap.get(w1)-countMap.get(w2));
        for (String word : countMap.keySet()) {
            minHeap.add(word);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while(minHeap.size() > 0) {
            result.addFirst(minHeap.poll());
        }

        return result;
    }

    private static Map<String, Integer> getCountMap(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0)+1);
        }

        return countMap;
    }

    public static void main(String[] args) {
        System.out.println(TopKFrequentWords.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
