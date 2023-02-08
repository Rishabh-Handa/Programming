package patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Given a string, find the length of the longest substring in it with no more
    than K distinct characters.

    Example 1:

    Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters
    is "araa".
 */
public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(maxSubstring("araaci", 2));
        System.out.println(maxSubstring("araacicici", 2));
        System.out.println(maxSubstring("cbbebi", 3));
        System.out.println(maxSubstring("aabbcc", 3));
    }

    private static int maxSubstring(String str, int k) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> characterSet = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int i=0; i<chars.length; i++) {
            characterSet.compute(chars[i], (ck,v) -> v == null ? 1 : v +1);

            if(characterSet.size() <= k) {
                max = Math.max(max, i-left+1);
            }
            while(characterSet.size() > k) {
                int count = characterSet.get(chars[left]) - 1;
                if(count == 0) {
                    characterSet.remove(chars[left]);
                } else {
                    characterSet.put(chars[left], count);
                }
                left++;
            }
        }
        return max;
    }
}
