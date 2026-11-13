package dsa.recursion.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SortAList
 *
 * <p>Sorts a list in ascending order using recursion only — a recursive insertion sort.
 *
 * <p><b>Idea (hypothesis / induction):</b>
 * <ol>
 *   <li>Remove the last element and assume {@code sort} correctly sorts the rest.</li>
 *   <li>{@code insert} places the removed element into its correct spot in the sorted remainder.</li>
 * </ol>
 * {@code insert} removes larger elements from the end until the right position is found, inserts, then
 * adds the removed elements back.
 *
 * <p><b>Complexity:</b> Time O(n^2), Space O(n) call stack.
 *
 * <p><b>NOTE:</b> the list must be mutable (e.g. {@code ArrayList}, not {@code Arrays.asList} directly).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SortAList {
    public static void sort(List<Integer> nums) {
        // Base case: an empty or single-element list is trivially sorted
        if (nums.size() <= 1) {
            return;
        }

        // Take off the last element, sort the rest, then insert it back in the right place
        int temp = nums.get(nums.size() - 1);
        nums.remove(nums.size()-1);
        sort(nums);
        insert(nums, temp);
    }

    /** Inserts {@code temp} into the already-sorted list so the list stays sorted. */
    private static void insert(List<Integer> nums, int temp) {
        // Base case: list is empty or temp is >= the largest element -> it belongs at the end
        if (nums.isEmpty() || nums.get(nums.size() - 1) <= temp) {
            nums.add(temp);
            return;
        }

        // Last element is bigger than temp: set it aside, insert temp deeper, then put it back
        int val = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        insert(nums, temp);
        nums.add(val);
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 7, 6, 4, 9));
        sort(nums);
        System.out.println(nums); // [2, 3, 4, 6, 7, 9]
    }
}
