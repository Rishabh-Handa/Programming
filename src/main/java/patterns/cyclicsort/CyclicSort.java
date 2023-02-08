package patterns.cyclicsort;

import java.util.Arrays;

/**
 * We are given an array containing ‘n’ objects.
 * Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence.
 * This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.
 *
 * Write a function to sort the objects in-place on their creation
 * sequence number in O(n)O(n) and without any extra space. For simplicity,
 * let’s assume we are passed an integer array containing only the sequence numbers,
 * though each number is actually an object.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 */
public class CyclicSort {

    public static void main(String[] args) {
        int[] result = {3,1,5,4,2};
        cyclicSortArray(result);
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));

        System.out.println();
        result = new int[]{2, 6, 4, 3, 1, 5};
        cyclicSortArray(result);
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));

        System.out.println();
        result = new int[]{1, 5, 6, 4, 3, 2};
        cyclicSortArray(result);
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
    }

    private static void cyclicSortArray(int[] nums) {
        int i=0;
        while(i<nums.length) {
            if(nums[i] == i+1) {
                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
