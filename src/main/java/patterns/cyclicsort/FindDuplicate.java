package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement #
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 *
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 *
 *
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.
 *
 * Example 1:
 *
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,4,4,3,2}));

        System.out.println(findDuplicate(new int[] {2, 1, 3, 3, 5, 4}));

        System.out.println(findDuplicate(new int[] {2, 4, 1, 4, 4}));

        System.out.println("All duplicates");

        System.out.println(findAllDuplicate(new int[] {3, 4, 4, 5, 5}));

        System.out.println(findAllDuplicate(new int[] {5, 4, 7, 2, 3, 5, 3}));
    }

    private static int findDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length) {
            int j = nums[i] - 1;
            if(nums[i] - 1 != i && nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for(i=0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                return nums[i];
            }
        }

        return -1;
    }

    private static List<Integer> findAllDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length) {
            int j = nums[i] - 1;
            if(nums[i] - 1 != i && nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(i=0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
