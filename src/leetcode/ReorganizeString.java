package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b)-counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();
        while(maxHeap.size()>1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();

            result.append(current);
            result.append(next);

            counts.put(current, counts.get(current)-1);
            counts.put(next, counts.get(next)-1);

            if(counts.get(current) > 0) {
                maxHeap.add(current);
            }

            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1) {
                return "";
            }
            result.append(last);
        }

        return result.toString();
    }
}
