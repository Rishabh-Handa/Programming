package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 * where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 */
public class ThreeSumSmallerThanTarget {
    public static void main(String[] args) {
        System.out.println(findThreesome(new int[]{-1,0,2,3}, 3));
        System.out.println(findThreesome(new int[]{-1, 4, 2, 1, 3}, 5));
    }

    private static int findThreesome(int[] nums, int target) {

        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            int sum = nums[i];
            int p1 = i+1;
            int p2 = nums.length - 1;
            while(p1 < p2) {
                int temp = sum + nums[p1] + nums[p2];
                if(temp < target) {
                    count = count + p2 - p1;
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        return count;
    }
}
