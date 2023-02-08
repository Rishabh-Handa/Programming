package patterns.twopointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 *
 * Example 1:
 *
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 */
public class MinimumWindowSort {

    public static void main(String[] args) {
        System.out.println(minWindow(new int[]{1,2,5,3,7,10,9,12}));
        System.out.println(minWindow(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(minWindow(new int[]{1, 2, 3}));
        System.out.println(minWindow(new int[]{3, 2, 1}));
        System.out.println(minWindow(new int[]{1,3,3,2,4}));
        System.out.println(minWindow(new int[]{1,3,5,2,4}));
    }

    private static int minWindow(int[] nums) {
        int l, r=1;
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        while(r < nums.length && nums[r] >= nums[r-1]) {
            r++;
        }

        if(r == nums.length) {
            return 0;
        }

        l = r-1;
        int max = nums[l];

        for(int i=r; i<nums.length; i++) {
            if(nums[i] < nums[i-1] || nums[i] < max) {
                r = i;
                max = Math.max(max, nums[r-1]);
                while(l-1 >= 0 && nums[l-1] > nums[r]) l--;
            }
        }

        return r - l + 1;
    }
}
