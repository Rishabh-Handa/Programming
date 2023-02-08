package patterns.twopointers;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        long sum = (long)Math.pow(10,9);
        System.out.println(findFourSum(new int[] {4,1,2,-1,1,-3}, 1));
        System.out.println(findFourSum(new int[] {2, 0, -1, 1, -2, 2}, 2));
    }

    private static List<List<Integer>> findFourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length - 3; i++) {
            for(int j=i+1; j<nums.length - 2; j++) {
                int sum = nums[i] + nums[j];
                int left = j+1;
                int right = nums.length - 1;
                while(left < right) {
                    int currSum = sum + nums[left] + nums[right];
                    if(currSum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if(currSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
