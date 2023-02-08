package patterns.modifiedBinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of numbers sorted in ascending order,
 * find the range of a given number ‘key’. The range of the ‘key’ will be the first
 * and last position of the ‘key’ in the array.
 *
 * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 *
 * Example 1:
 *
 * Input: [4, 6, 6, 6, 9], key = 6
 * Output: [1, 3]
 */
public class FindRange {
    public static void main(String[] args) {
        System.out.println(findRange(new int[] {4,6,6,6,9}, 6));
        System.out.println(findRange(new int[] {4,5,6,7,9}, 4));
        System.out.println(findRange(new int[] {4,5,6,7,9}, 9));
        System.out.println(findRange(new int[] {4,6,6,6,9}, 60));
    }

    private static List<Integer> findRange(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == k) {
                int left = leftBinary(nums, start, mid, k);
                int right = rightBinary(nums, mid, end, k);
                return Arrays.asList(left, right);
            }

            if(k < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return Arrays.asList(-1,-1);
    }

    private static int leftBinary(int[] nums, int start, int end, int k) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(k == nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int rightBinary(int[] nums, int start, int end, int k) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(k == nums[mid]) {
                start = mid + 1;
            } else {
               end = mid - 1;
            }
        }
        return start - 1;
    }


}
