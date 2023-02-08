package patterns.cyclicsort;

import java.util.Arrays;

/**
 *We are given an array containing ‘n’
 *  distinct numbers taken from the range 0 to ‘n’.
 *  =Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 *
 * Example 1:
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{4,0,3,1}));

        System.out.println(missingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));

        System.out.println(missingNumber(new int[]{2,0,3,1}));
    }
    public static int missingNumber(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i && nums[i] < nums.length) {
                swap(nums, i, nums[i]);
                i--;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

