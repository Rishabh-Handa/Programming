package patterns.modifiedBinarySearch;

/**
 * Problem Statement #
 * Find the maximum value in a given Bitonic array. An array is considered
 * bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 12, 4, 2]
 * Output: 12
 * Explanation: The maximum number in the input bitonic array is '12'.
 */
public class FindMaxima {
    public static void main(String[] args) {
        System.out.println(findMaxima(new int[] {1,3,8,12,4,2}));
        System.out.println(findMaxima(new int[] {3,8,3,1}));
        System.out.println(findMaxima(new int[] {1,3,8,12}));
        System.out.println(findMaxima(new int[] {10,9,8}));
    }

    private static int findMaxima(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isMax = true;
            boolean leftSide = false;

            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                isMax = false;
                leftSide = true;
            }

            if(mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                isMax = false;
            }

            if(isMax) {
                return nums[mid];
            }

            if(leftSide) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
