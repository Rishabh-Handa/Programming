package patterns.modifiedBinarySearch;

/**
 * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
 *
 * You can assume that the array does not have any duplicates.
 *
 * Example 1:
 *
 * Input: [10, 15, 1, 3, 8]
 * Output: 2
 * Explanation: The array has been rotated 2 times.
 */
public class RotationCount {
    public static void main(String[] args) {
        System.out.println(findRotations(new int[]{10,15,1,3,8}));
        System.out.println(findRotations(new int[]{8,10,12,13,14,6,7}));
        System.out.println(findRotations(new int[]{10,11,4,5,6,8,9}));
    }

    private static int findRotations(int[] nums) {
        if(nums == null) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int index = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                index = mid;
                break;
            }

            if(nums[start] < nums[mid] && nums[mid] < nums[end]) {
                index = start;
                break;
            } else if(nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
