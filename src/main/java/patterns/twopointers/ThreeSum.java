package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] x = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Arrays.sort(x);
        System.out.println(findThreesome(new int[]{-3,0,1,2,-1,1,-2}));
        System.out.println(findThreesome(new int[]{-5, 2, -1, -2, 3}));

    }

    private static List<List<Integer>> findThreesome(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int sum = nums[i];
            int p1 = i+1;
            int p2 = nums.length - 1;
            while(p1 < p2) {
                int temp = sum + nums[p1] + nums[p2];
                if(temp == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[p1]);
                    res.add(nums[p2]);
                    result.add(res);
                    p1++;
                    p2--;
                } else if(temp < 0) {
                    p1++;
                } else {
                    p2--;
                }

            }
        }

        return result;
    }
}
