package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array of characters where each character represents a fruit tree,
 *  you are given two baskets and your goal is to put maximum number of fruits in each basket.
 *  The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot,
 * i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */
public class FruitsAndTrees {

    public static void main(String[] args) {
        System.out.println(findFruits(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(findFruits(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    private static int findFruits(char[] chars) {
        if(chars == null || chars.length <= 0) {
            return -1;
        }

        Map<Character, Integer> treeMap = new HashMap<>();

        int windowStart = 0;
        int max = Integer.MIN_VALUE;

        for(int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
            treeMap.compute(chars[windowEnd], (ck, cv) -> cv == null ? 1 : cv + 1);
            if(treeMap.size() == 2) {
                max = Math.max(max, windowEnd - windowStart + 1);
            }

            while(treeMap.size() > 2) {
                int count = treeMap.get(chars[windowStart]) - 1;
                if(count == 0) {
                    treeMap.remove(chars[windowStart]);
                } else {
                    treeMap.put(chars[windowStart], count);
                }
                windowStart++;
            }

        }

        return max;
    }
}
