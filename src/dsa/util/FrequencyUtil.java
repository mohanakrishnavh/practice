package dsa.util;

import java.util.HashMap;
import java.util.Map;

/**
 * FrequencyUtil
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class FrequencyUtil {
    public static Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int element : nums) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        return countMap;
    }
}
