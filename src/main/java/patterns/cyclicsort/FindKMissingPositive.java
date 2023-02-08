package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array containing numbers and a number ‘k’,
 * find the first ‘k’ missing positive numbers in the array.
 *
 * Example 1:
 *
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 */
public class FindKMissingPositive {
    public static void main(String[] args) {
        System.out.println(findKMissing(new int[]{3, -1, 4, 5, 5}, 3));

        System.out.println(findKMissing(new int[]{2, 3, 4}, 3));

        System.out.println(findKMissing(new int[]{-2, -3, 4}, 2));

        System.out.println(findKMissing(new int[]{4,2,8,6}, 6));

    }

    private static List<Integer> findKMissing(int[] nums, int k) {
        int i = 0;
        while(i < nums.length) {
            int j = nums[i] - 1;
            if(nums[i] > 0 && nums[i] - 1 != i && j < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> excludeList = new ArrayList<>();
        for (i=0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                result.add(i+1);
                excludeList.add(nums[i]);
            }
        }

        int n = nums.length + 1;
        while (result.size() < k) {
            if(!excludeList.contains(n)) {
                result.add(n);
            }
            n++;
        }

        while (result.size() > k) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
