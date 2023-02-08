package patterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Example 1:
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */
public class LongestNonRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findNonRepeating("aabccbb"));
        System.out.println(findNonRepeating("abbbb"));
        System.out.println(findNonRepeating("abccde"));
    }

    private static int findNonRepeating(String str) {
        Set<Character> characterSet = new HashSet<>();
        int left = 0;
        int max = Integer.MIN_VALUE;

        char[] chars = str.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(characterSet.contains(chars[i])) {
                while(chars[left] != chars[i]) {
                    characterSet.remove(chars[left]);
                    left++;
                }
                left++;
            } else {
                characterSet.add(chars[i]);
            }

            max = Math.max(max, characterSet.size());
        }

        return max;
    }
}
