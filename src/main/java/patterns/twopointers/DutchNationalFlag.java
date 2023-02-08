package patterns.twopointers;

import java.util.Arrays;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence,
 * we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors:
 * red, white and blue; and since our input array also consists of
 * three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] nums = {1,0,2,1,0};
        sortArray(nums);
        Arrays.stream(nums).forEach(i -> System.out.print(i + ","));
        System.out.println();
    }

    private static void sortArray(int[] nums) {
        int begin = 0, end = nums.length - 1;
        int i = 0;
        while(i < end) {
            if (nums[i] == 0) {
                swap(nums, begin, i);
                begin++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
