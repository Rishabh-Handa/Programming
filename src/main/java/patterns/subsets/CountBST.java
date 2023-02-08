package patterns.subsets;

import java.util.HashMap;
import java.util.Map;

/**
 * Count of Structurally Unique Binary Search Trees (hard) #
    Given a number ‘n’, write a function to return the count of
    structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
*/
 public class CountBST {
     static Map<Integer, Integer> cache = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(printCount(5));
    }

    private static int printCount(int num) {
        if(num <= 1) {
            return 1;
        }

        if(cache.containsKey(num)) {
            return cache.get(num);
        }
        int result = 0;
        for(int i=0; i<num; i++) {
            int left = printCount(i);
            int right = printCount(num - i - 1);
            result += left * right;
        }
        return result;
    }
}
