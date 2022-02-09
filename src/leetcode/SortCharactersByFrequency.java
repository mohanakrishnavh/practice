package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = counts.get(ch);
            String key = Character.toString(ch);
            sb.append(key.repeat(count));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(SortCharactersByFrequency.frequencySort("tree"));
        System.out.println(SortCharactersByFrequency.frequencySort("cccaaa"));
        System.out.println(SortCharactersByFrequency.frequencySort("Aabb"));
    }
}
