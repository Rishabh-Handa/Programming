package patterns.xor;

/**
 * Problem Statement #
 * In a non-empty array of integers, every number appears twice except for one, find that single number.
 *
 * Example 1:
 *
 * Input: 1, 4, 2, 1, 3, 2, 3
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(findNonRepeating(new int[] {1,4,2,1,3,2,3}));
    }

    private static int findNonRepeating(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return -1;
        }

        int xor = nums[0];
        for(int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }
}
