package patterns.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of numbers and a number ‘K’,
 * we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
 *
 * Example 1:
 *
 * Input: [7, 3, 5, 8, 5, 3, 3], and K=2
 * Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have
 */
public class MaximumDistinctElements {

    public static void main(String[] args) {
        System.out.println(findMaxDistinct(new int[] {7,3,5,8,5,3,3}, 2));
        System.out.println(findMaxDistinct(new int[] {7,3,5,8,5,3,3}, 3));
    }

    private static int findMaxDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int num: map.keySet()) {
            maxHeap.offer(num);
        }

        for(int i=0; i<k; i++) {
            int num = maxHeap.poll();
            map.put(num, map.get(num) - 1);

            if(map.get(num) > 0) {
                maxHeap.offer(num);
            }
        }

        int count = 0;

        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                count++;
            }
        }

        return count;
    }
}
