package patterns.modifiedBinarySearch;

/**
 * Given an array of numbers sorted in an ascending order,
 * find the ceiling of a given number ‘key’. The ceiling of the ‘key’ will be the smallest
 * element in the given array greater than or equal to the ‘key’.
 *
 * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
 *
 * Example 1:
 *
 * Input: [1, 4, 6, 10], key = 6
 * Output: 1
 * Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
 */
public class FindCeil {
    public static void main(String[] args) {
        System.out.println(findCeil(new int[] {1,4,6,10}, 3));
        System.out.println(findCeil(new int[] {1,4,6,10}, 5));
        System.out.println(findCeil(new int[] {1,4,6,10}, 9));
        System.out.println(findCeil(new int[] {1,4,6,10}, 15));
        System.out.println(findCeil(new int[] {1,4,6,10}, 6));
    }

    private static int findCeil(int[] nums, int k) {
        if(nums == null) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            max = Math.max(max, nums[start]);
            int mid = start + (end - start) / 2;
            if(nums[mid] == k) {
                return k;
            }

            if(k < nums[mid]) {
                max = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return max;
    }
}
