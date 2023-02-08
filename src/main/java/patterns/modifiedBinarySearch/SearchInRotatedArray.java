package patterns.modifiedBinarySearch;

/**
 * Given an array of numbers which is sorted in ascending order and
 * also rotated by some arbitrary number, find if a given ‘key’ is present in it.
 *
 * Write a function to return the index of the ‘key’ in the rotated array.
 * If the ‘key’ is not present, return -1. You can assume that the given array does not have any duplicates.
 *
 * Example 1:
 *
 * Input: [10, 15, 1, 3, 8], key = 15
 * Output: 1
 * Explanation: '15' is present in the array at index '1'.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        System.out.println(searchKey(new int[] {10,15,1,3,8}, 15));
        System.out.println(searchKey(new int[] {4, 5, 7, 9, 10, -1, 2}, 10));
    }

    private static int searchKey(int[] nums, int k) {
        if(nums == null) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == k) {
                return mid;
            }

            if(k < nums[mid]) {
                if(nums[mid] > nums[end] && k < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] < nums[end] && k > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
