package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0451_SortCharacterByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Map<Character, Integer> freqMap = getFreqMap(s);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder builder = new StringBuilder();
        int freq = 0;
        char ch;
        while (!maxHeap.isEmpty()) {
            ch = maxHeap.poll();
            freq = freqMap.get(ch);

            while (freq > 0) {
                builder.append(ch);
                freq--;
            }
        }

        return builder.toString();
    }

    private Map<Character,Integer> getFreqMap(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        return freqMap;
    }
}
