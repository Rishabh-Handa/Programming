package patterns.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given ‘N’ ropes with different lengths,
 * we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 *
 * Example 1:
 *
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
 */
public class ConnectNRopes {
    public static void main(String[] args) {
        System.out.println(connectRopes(new int[]{1,3,11,5}));
        System.out.println(connectRopes(new int[]{3,4,5,6}));
        System.out.println(connectRopes(new int[]{1,3,11,5,2}));
    }

    private static int connectRopes(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
        }

        int sum = 0;
        while(minHeap.size() > 1) {
            int least = minHeap.poll();
            int secondLast = minHeap.poll();

            int cost = least + secondLast;
            sum += cost;
            minHeap.offer(cost);
        }

        return sum;
    }
}
