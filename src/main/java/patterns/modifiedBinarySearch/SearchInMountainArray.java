package patterns.modifiedBinarySearch;

/**
 * Given a Bitonic array, find if a given ‘key’ is present in it.
 * An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 *
 * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 4, 3], key=4
 * Output: 3
 */
public class SearchInMountainArray {
    public static void main(String[] args) {
        System.out.println(searchInMountain(new int[] {1,3,8,4,3}, 4));
        System.out.println(searchInMountain(new int[] {3,4,6,12,8,7,5,2,1}, 4));
        System.out.println(searchInMountain(new int[] {3,4,6,12,8,7,5,2,1}, 2));
        System.out.println(searchInMountain(new int[] {3,4,6,12,8,7,5,2,1}, 22));
        System.out.println(searchInMountain(new int[] {3,4,6,12,8,7,5,2,1}, 12));
    }

    private static int searchInMountain(int[] nums, int k) {
        return binarySearch(nums, 0, nums.length - 1, k);
    }

    static int binarySearch(int[] nums, int start, int end, int k) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == k) {
                return mid;
            }

            if(k > nums[mid]) {
                if(mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    int otherHalf = binarySearch(nums, start, mid - 1, k);
                    if(otherHalf != -1) {
                        return otherHalf;
                    }
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
