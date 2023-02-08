package patterns.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  Given an array of sorted numbers and a target sum,
 *  find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(findTwoSum(new int[]{1,2,3,4,6}, 6));
        System.out.println(findTwoSum(new int[]{2,5,9,11}, 11));
    }

    private static List<Integer> findTwoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(target == sum) {
                return Arrays.asList(left, right);
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }

        }

        return Collections.emptyList();
    }
}
