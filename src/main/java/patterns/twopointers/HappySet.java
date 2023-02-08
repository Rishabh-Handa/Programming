package patterns.twopointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Any number will be called a happy number if, after repeatedly replacing
 * it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 *
 * Example 1:
 *
 * Input: 23
 * Output: true (23 is a happy number)
 * Explanations: Here are the steps to find out that 23 is a happy number:
 */
public class HappySet {
    public static void main(String[] args) {
        System.out.println(isHappy(23));
        System.out.println(isHappy(12));
    }

    // using hashset
    static boolean isHappy(int n) {
        Set<Integer> happySet = new HashSet<>();

        while(n != 1) {
            int sum = 0;
            int currN = n;
            while(currN > 0) {
                sum += Math.pow(currN % 10, 2);
                currN = currN / 10;
            }
            if(happySet.contains(sum)) {
                return false;
            }
            happySet.add(sum);
            n = sum;
        }

        return true;
    }
}
