package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
 * We are given an unsorted array containing numbers
 * taken from the range 1 to ‘n’. The array can have duplicates,
 * which means some numbers will be missing. Find all those missing numbers.
 *
 * Example 1:
 *
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 */
public class FindAllMissingNumbers {

    public static void main(String[] args) {
        int[] result = findAllMissingNumbers(new int[]{2,3,1,8,2,3,5,1});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));

        System.out.println();
        result = findAllMissingNumbers(new int[]{2,4,1,2});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));

        System.out.println();
        result = findAllMissingNumbers(new int[]{2,3,2,1});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
    }



    private static int[] findAllMissingNumbers(int[] nums) {
        int i=0;
        while(i < nums.length) {
            if(nums[i] <= nums.length && nums[i] - 1 != i) {
                int j = nums[i] - 1;
                if(nums[j] != nums[i]) {
                    swap(nums, i, j);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(i=0; i<nums.length; i++) {
            if(nums[i] - 1 != i) {
                res.add(i+1);
            }
        }

        return res.stream().mapToInt(k -> k).toArray();
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
