package patterns.modifiedBinarySearch;

/**
 * Problem Statement #
 * Given an array of numbers sorted in ascending order,
 * find the element in the array that has the minimum difference with the given ‘key’.
 *
 * Example 1:
 *
 * Input: [4, 6, 10], key = 7
 * Output: 6
 * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 */
public class FindMinDiffElement {
    public static void main(String[] args) {
        System.out.println(findMinDiff(new int[]{4,6,10}, 7));
        System.out.println(findMinDiff(new int[]{4,6,10}, 4));
        System.out.println(findMinDiff(new int[]{4,6,10}, 17));
        System.out.println(findMinDiff(new int[]{1,3,8,10,15}, 12));
        System.out.println(findMinDiff(new int[]{1,3,8,10,15}, 2));
    }

    private static int findMinDiff(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int result = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == k) {
                return 0;
            }
            int diff = Math.abs(k - nums[mid]);
            if(minDiff < diff) {
                break;
            }
            minDiff = diff;
            result = nums[mid];
            if(k > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
