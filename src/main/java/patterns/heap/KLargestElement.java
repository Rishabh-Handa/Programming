package patterns.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 *
 * Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 12, 2, 11], K = 3
 * Output: [5, 12, 11]
 */
public class KLargestElement {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,1,5,12,2,11}, 3));
    }
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i < nums.length; i++) {
            if(queue.isEmpty() || queue.size() < k) {
                queue.offer(nums[i]);
                continue;
            }

            if(queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        return queue.peek();
    }
}
