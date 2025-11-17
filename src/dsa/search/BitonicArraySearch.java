package dsa.search;

/**
 * BitonicArraySearch
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BitonicArraySearch {
    public static int findInBitonicArray(int[] nums, int target) {
        int max = BitonicArrayMaximumElement.getMaximumElement(nums);

        if (nums[max] == target) {
            return max;
        }

        return Math.max(
                BinarySearch.search(nums, 0, max - 1, target),
                ReverseBinarySearch.search(nums, max + 1, nums.length - 1, target));
    }

    public static void main(String[] args) {
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 12));
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 4));
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 3));
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, -1));
    }
}
