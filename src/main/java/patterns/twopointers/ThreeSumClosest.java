package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible,
 * return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 *
 * Example 1:
 *
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(findThreesome(new int[]{-2,0,1,2}, 2));
        System.out.println(findThreesome(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(findThreesome(new int[]{1, 0, 1, 1}, 100));
    }
    private static int findThreesome(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int sum = nums[i];
            int p1 = i+1;
            int p2 = nums.length - 1;
            
            while(p1 < p2) {
                int temp = sum + nums[p1] + nums[p2];
                if(temp == target) {
                    p1++;
                    p2--;
                    continue;
                } else if(temp < target) {
                    p1++;
                } else {
                    p2--;
                }
                if(min > Math.abs(target - temp)) {
                    min = Math.abs(target - temp);
                    closest = temp;
                }
            }
        }

        return closest;
    }
}
