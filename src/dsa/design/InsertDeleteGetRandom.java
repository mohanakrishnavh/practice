package dsa.design;

import java.util.*;

/**
 * RandomizedSet
 * 
 * <p>A data structure that supports insert, delete, and getRandom operations in O(1) average time.
 * Uses a combination of HashMap (for O(1) lookup) and ArrayList (for O(1) random access).
 * The key insight is to maintain the invariant that the HashMap stores the index of each value
 * in the ArrayList, allowing constant-time removal by swapping with the last element.
 */
class RandomizedSet {
    Map<Integer, Integer> valueIndexMap;
    List<Integer> values;
    Random random;

    /**
     * Initializes the RandomizedSet data structure.
     */
    public RandomizedSet() {
        values = new ArrayList<>();
        valueIndexMap = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value into the set if it's not already present.
     * 
     * <p>Time Complexity: O(1) average
     * 
     * @param val the value to insert
     * @return true if the value was not present and was inserted, false otherwise
     */
    public boolean insert(int val) {
        // If the value is not present
        if (valueIndexMap.containsKey(val)) {
            return false;
        }

        // Insert the value to the end of the list and store its index in the map
        values.add(val);
        valueIndexMap.put(val, values.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set if it's present.
     * 
     * <p>Uses a swap-with-last technique: swaps the element to remove with the last element,
     * then removes the last element. This maintains O(1) time complexity.
     * 
     * <p>Time Complexity: O(1) average
     * 
     * @param val the value to remove
     * @return true if the value was present and was removed, false otherwise
     */
    public boolean remove(int val) {
        // If the value is not present
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }

        int index = valueIndexMap.get(val);
        int lastElement = values.get(values.size() - 1);

        values.set(index, lastElement);
        valueIndexMap.put(lastElement, index);

        values.remove(values.size() - 1);
        valueIndexMap.remove(val);

        return true;
    }

    /**
     * Returns a random element from the current set with uniform probability.
     * 
     * <p>Time Complexity: O(1)
     * 
     * @return a random element from the set
     */
    public int getRandom() {
        int randIndex = random.nextInt(values.size());
        return values.get(randIndex);
    }
}

/**
 * InsertDeleteGetRandom
 * 
 * <p>This class demonstrates the RandomizedSet implementation that supports
 * insert, delete, and getRandom operations all in O(1) average time complexity.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class InsertDeleteGetRandom {
}
