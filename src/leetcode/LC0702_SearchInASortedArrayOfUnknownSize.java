package leetcode;

public class LC0702_SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = start + 1;
        while (target > reader.get(end)) {
            start = end;
            end = end * 2;
        }

        return binarySearch(reader, start, end, target);
    }

    public int binarySearch(ArrayReader reader, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = reader.get(mid);

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
}
