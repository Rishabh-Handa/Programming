package patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class PrintAllSubsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(allsubsets(arr));
    }

    private static List<List<Integer>> allsubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {

            int size = result.size();
            for(int j=0; j<size; j++) {
                List<Integer> currList = result.get(j);

                List<Integer> newList = new ArrayList<>(currList);
                newList.add(nums[i]);
                result.add(newList);
            }
        }

        return result;
    }
}
