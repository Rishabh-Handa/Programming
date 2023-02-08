package patterns.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem Statement #
 * Given a sorted number array and two integers ‘K’ and ‘X’,
 * find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order.
 * ‘X’ is not necessarily present in the array.
 *
 * Example 1:
 *
 * Input: [5, 6, 7, 8, 9], K = 3, X = 7
 * Output: [6, 7, 8]
 */
public class KClosestNumbers {
    public static void main(String[] args) {
        System.out.println(findKClosest(new int[] {5,6,7,8,9}, 7, 3));
        System.out.println(findKClosest(new int[] {2,4,5,6,9}, 6, 3));
        System.out.println(findKClosest(new int[] {2,4,5,6,9}, 10, 3));
    }

    private static List<Integer> findKClosest(int[] nums, int x, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Math.abs(b - x) - Math.abs(a - x));

        for(int num: nums) {
            maxHeap.offer(num);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }
}
