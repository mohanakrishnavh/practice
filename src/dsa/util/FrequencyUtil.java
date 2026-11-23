package dsa.util;

import java.util.HashMap;
import java.util.Map;

/**
 * FrequencyUtil
 * 
 * Utility methods for counting element frequencies.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FrequencyUtil {
    /**
     * Counts how many times each value occurs in an array.
     *
     * @param nums the input array
     * @return map from each distinct value to its number of occurrences
     */
    public static Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int element : nums) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        return countMap;
    }
}
