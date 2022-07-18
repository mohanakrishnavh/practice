package dsa.design;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> valueIndexMap;
    List<Integer> values;
    Random random;

    public RandomizedSet() {
        values = new ArrayList<>();
        valueIndexMap = new HashMap<>();
        random = new Random();
    }

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

    public int getRandom() {
        int randIndex = random.nextInt(values.size());
        return values.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class InsertDeleteGetRandom {
}
