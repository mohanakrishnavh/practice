package leetcode;

public class LC1095_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int max = getMaximumElement(mountainArr, length);

        if (target == mountainArr.get(max)) {
            return max;
        }

        int leftIndex = binarySearch(mountainArr, 0, max - 1, target);
        int rightIndex = reverseBinarySearch(mountainArr, max + 1, length - 1, target);

        if (leftIndex == -1 || rightIndex == -1) {
            return Math.max(leftIndex, rightIndex);
        }

        return Math.min(leftIndex, rightIndex);
    }

    public int getMaximumElement(MountainArray mountainArr, int length) {
        int start = 0;
        int end = length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            int previousVal = mountainArr.get(mid - 1);
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);

            if (midVal > previousVal && midVal > nextVal) {
                return mid;
            }

            if (midVal < nextVal) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return mid;
    }

    public int binarySearch(MountainArray mountainArr, int startIndex, int endIndex, int target) {
        int start = startIndex;
        int end = endIndex;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (target == midVal) {
                return mid;
            }

            if (target < midVal) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int reverseBinarySearch(MountainArray mountainArr, int startIndex, int endIndex, int target) {
        int start = startIndex;
        int end = endIndex;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (target == midVal) {
                return mid;
            }

            if (target < midVal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
