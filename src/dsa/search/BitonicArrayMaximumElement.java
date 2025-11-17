package dsa.search;

/**
 * BitonicArrayMaximumElement
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BitonicArrayMaximumElement {
    public static int getMaximumElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumElement(new int[]{0, 1, 0}));
        System.out.println(getMaximumElement(new int[]{0, 2, 1, 0}));
        System.out.println(getMaximumElement(new int[]{0, 10, 5, 2}));
    }
}
