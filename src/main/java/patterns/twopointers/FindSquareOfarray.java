package patterns.twopointers;

import java.util.Arrays;

/**
 * Given a sorted array, create a new array containing squares of all the number
 * of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */
public class FindSquareOfarray {

    public static void main(String[] args) {
        int[] result = findSortedSquare(new int[]{-2,-1,0,2,3});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
        System.out.println();

        result = findSortedSquare(new int[]{-3,-1,0,1,2});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
        System.out.println();

        result = findSortedSquare(new int[]{-3,-2,-1});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
        System.out.println();

        result = findSortedSquare(new int[]{1,2,3});
        Arrays.stream(result).forEach(i -> System.out.print(i + ","));
        System.out.println();


    }

    //better approach
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }


    private static int[] findSortedSquare(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int p1 = -1;
        int p2 = 0;

        while(p2 < nums.length) {
            if(nums[p2] >= 0) {
                break;
            }
            p2++;
            p1++;
        }

        int[] result = new int[nums.length];
        int rIndex = 0;
        while(p1 >= 0 && p2 < nums.length) {
            if(Math.abs(nums[p1]) < Math.abs(nums[p2])) {
                result[rIndex] = nums[p1] * nums[p1];
                p1--;
            } else {
                result[rIndex] = nums[p2] * nums[p2];
                p2++;
            }
            rIndex++;
        }

        while(p1 >= 0) {
            result[rIndex] = nums[p1] * nums[p1];
            rIndex++;
            p1--;
        }

        while(p2 < nums.length) {
            result[rIndex] = nums[p2] * nums[p2];
            rIndex++;
            p2++;
        }
        return result;
    }
}
