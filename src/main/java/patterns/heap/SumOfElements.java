package patterns.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
 *
 * Example 1:
 *
 * Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
 * Output: 23
 * Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
 * between 5 and 15 is 23 (11+12).
 */
public class SumOfElements {
    public static void main(String[] args) {
        System.out.println(findSum(new int[] {1,3,12,5,15,11}, 3, 6));
        System.out.println(findSum(new int[] {3,5,8,7}, 1, 4));
    }

    private static int findSum(int[] nums, int k1, int k2) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int queueSize = k2 - 1;

        for(int num: nums) {
            maxHeap.offer(num);
            if(maxHeap.size() > queueSize) {
                maxHeap.poll();
            }
        }

        int sum = 0;
        int elements = k2 - k1 - 1;

        for(int i=0; i < elements; i++) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
