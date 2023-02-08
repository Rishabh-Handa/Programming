package patterns.subsets;

import java.util.*;

public class AllPermutationsWithDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(allsubsets(arr));
    }

    private static List<List<Integer>> allsubsets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {

            int size = result.size();
            List<List<Integer>> resultList = new ArrayList<>(result);
            for(int j=0; j<size; j++) {
                List<Integer> currList = resultList.get(j);

                List<Integer> newList = new ArrayList<>(currList);
                newList.add(nums[i]);
                result.add(newList);
            }
        }

        return new ArrayList<>(result);
    }
}
