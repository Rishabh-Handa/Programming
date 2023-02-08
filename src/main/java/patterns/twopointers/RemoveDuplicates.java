package patterns.twopointers;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2,3,3,3,6,6,9,9}));
        System.out.println(removeDuplicates(new int[]{2,2,2,11}));
    }

    private static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int length = 1;
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[left] == nums[right]) {
                right++;
            } else {
                left = right;
                length++;
            }
        }
        return length;
    }
}
