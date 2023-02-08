package patterns.heap;

import java.util.*;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * Example 1:
 *
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' apeared twice.
 */
public class TopKNumbers {
    public static void main(String[] args) {
        System.out.println(findFrequentNumbers(new int[] {1,3,5,12,11,12,11}, 2));
    }

    private static List<Integer> findFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(int num: map.keySet()) {
            queue.offer(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i < k; i++) {
            if(!queue.isEmpty()) {
                result.add(queue.poll());
            }
        }

        return result;
    }
}
