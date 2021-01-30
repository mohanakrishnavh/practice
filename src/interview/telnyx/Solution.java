package interview.telnyx;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1, 1, 5, 5, 4, 2, 8}, 6) == 3);
        System.out.println(countPairs2(new int[]{1, 5, 4, 2, 8}, 6) == 2);

    }

    public static int countPairs(int[] arr, int sum) {
        int count = 0;

        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (Integer element : arr) {
          int diff = sum-element;
          int elementCount = elementCountMap.getOrDefault(diff, 0);
          if (elementCount > 0) {
              count += 1;
              elementCountMap.put(diff, elementCount-1);
          }

          elementCountMap.put(element, elementCountMap.getOrDefault(element, 0)+1);
        }

        return count;
    }

    public static int countPairs2(int[] arr, int sum) {
        int count = 0;
        Arrays.sort(arr);

        for (Integer element : arr) {
            int index = Arrays.binarySearch(arr, sum-element);

            if (index != -1) {
                count++;
            }
        }
        return count;
    }
}

/*{1, 5, 4, 2, 8}
sort : {1, 2, 4, 5, 8}

iteration 1 : uniqueElements[1], count = 0
iteration 2:  uniqueElements[1, 5], count= 1
iteration 3 : uniqueElements[1, 5, 4], count = 1
iteration 4 : uniqueElements[1, 5, 4, 2], count = 2
iteration 4 : uniqueElements[1, 5, 4, 2], count = 2*/


// Set: []
/*iteration 1 : uniqueElements[1], count = 0
iteration 2:  uniqueElements[1, 5], count= 1
iteration 3 : uniqueElements[1, 5, 4], count = 1
iteration 4 : uniqueElements[1, 5, 4, 2], count = 2
iteration 4 : uniqueElements[1, 5, 4, 2], count = 2*/
