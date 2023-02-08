package patterns.cyclicsort;

/**
 * Find the Smallest Missing Positive Number (medium) #
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 *
 * Example 1:
 *
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 */
public class FindSmallestPositive {
    public static void main(String[] args) {
        System.out.println(findSmallestPositive(new int[]{-3, 1, 0, 5, 4, 2}));

        System.out.println(findSmallestPositive(new int[]{3, -2, 0, 1, 2}));

        System.out.println(findSmallestPositive(new int[]{3, 2, 5, 1}));
    }

    private static int findSmallestPositive(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int j = nums[i] - 1;
            if(nums[i] > 0 && nums[i] - 1 != i && j < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i=0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                break;
            }
        }

        return i + 1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
