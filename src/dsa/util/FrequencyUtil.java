package dsa.util;

import java.util.HashMap;
import java.util.Map;

public class FrequencyUtil {
    public static Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int element : nums) {
            countMap.put(element, countMap.getOrDefault(element, 0)+1);
        }

        return countMap;
    }
}
