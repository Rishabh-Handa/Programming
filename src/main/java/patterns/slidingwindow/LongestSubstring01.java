package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 *  find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */
public class LongestSubstring01 {
    public static void main(String[] args) {
        System.out.println(findLongestString(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLongestString(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }

    private static int findLongestString(int[] arr, int k) {
        int left = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {

            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            int zCount = freqMap.get(0);
            if(zCount > k) {
                int count = freqMap.get(arr[left]) - 1;
                freqMap.put(arr[left], count);
                left++;
            }
            zCount = freqMap.get(0);
            if(zCount <= k) {
                max = Math.max(max, i - left + 1);
            }

        }

        return max;
    }
}
