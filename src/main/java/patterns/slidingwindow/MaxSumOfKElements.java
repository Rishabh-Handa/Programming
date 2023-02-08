package patterns.slidingwindow;

/**
 *  Given an array of positive numbers and a positive number ‘k’,
 *  find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumOfKElements {

    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        System.out.println("Result = " + maxSum(arr, 3));

        int[] arr2 = {2,3,4,1,5};
        System.out.println("Result = " + maxSum(arr2, 2));

    }

    static int maxSum(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int window = 0;
        for(int i=0; i<k; i++) {
            window += arr[i];
        }
        max = window;

        for(int i=k; i<arr.length; i++) {
            int prev = i-k;
            window = window - arr[prev] + arr[i];
            max = Math.max(max, window);
        }
        return max;
    }
}
