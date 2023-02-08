package patterns.twopointers;

public class RemoveKeyUnsorted {
    public static void main(String[] args) {
        System.out.println(removeKey(new int[]{3,2,3,6,3,10,9,3}, 3));
        System.out.println(removeKey(new int[]{2,11,2,2,1}, 2));
    }

    private static int removeKey(int[] nums, int key) {
        int index = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != key) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
