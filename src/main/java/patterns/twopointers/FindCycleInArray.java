package patterns.twopointers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a method to determine if the array has a cycle.
 * The cycle should have more than one element and should follow
 * one direction which means the cycle should not contain both forward and backward movements.
 *
 * Example 1:
 *
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 */
public class FindCycleInArray {
    public static void main(String[] args) {
//        System.out.println(findCycle(new int[]{1,2,-1,2,2}));
//
//        System.out.println(findCycle(new int[]{2,2,-1,2}));
//
//        System.out.println(findCycle(new int[]{2,1,-1,-2}));
//
//        System.out.println(findCycle(new int[]{2,2,-2,2}));

        System.out.println(circularArrayLoop(new int[] {-1,-2,-3,-4,-5,6}));

    }

    private static boolean findCycle(int[] nums) {
        int l = nums.length;
        int slow = 0;


        while(slow < l) {
            int fast = slow;
            Set<Integer> visited = new HashSet<>();
            while (!visited.contains(fast)) {
                visited.add(fast);
                fast = (fast + nums[fast]) % l;
            }
            int positive = 0;
            int negative = 0;
            for(int index: visited) {
                if(nums[index] > 0) {
                    positive++;
                } else {
                    negative++;
                }
            }

            if(positive == 0 && negative > 1) {
                System.out.println(visited);
                return true;
            } else if(negative == 0 && positive > 1) {
                System.out.println(visited);
                return true;
            }
            slow++;
        }

        return false;
    }

    public static boolean circularArrayLoop(int[] nums) {
        int l = nums.length;


        for(int slow = 0; slow < l; slow++) {
            int fast = slow;
            Set<Integer> visited = new HashSet<>();
            int sign = nums[slow] > 0 ? 1 : -1;

            boolean continueLoop = false;
            while (!visited.contains(fast)) {
                visited.add(fast);
                fast = (fast + nums[fast]) % l;
                if(fast < 0) {
                    fast = l + fast;
                }
                int sign2 = nums[fast] > 0 ? 1 : -1;
                if(sign != sign2) {
                    continueLoop = true;
                    break;
                }
            }

            if(continueLoop) {
                continue;
            }

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}
