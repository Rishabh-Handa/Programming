package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing ‘n’
 * numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’,
 * but due to a data error, one of the numbers got duplicated which
 * also resulted in one number going missing. Find both these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 */
public class CorruptPair {
    public static void main(String[] args) {
        System.out.println(findCorruptPair(new int[]{3, 1, 2, 5, 2}));

        System.out.println(findCorruptPair(new int[]{3, 1, 2, 3, 6, 4}));
    }

    private static List<Integer> findCorruptPair(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] - 1 != i && nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(i + 1);
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
