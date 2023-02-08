package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace
 * no more than ‘k’ letters with any letter, find the length of the longest substring
 * having the same letters after replacement.
 *
 * Example 1:
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(findSubstring("aabccbb", 2));
        System.out.println(findSubstring("abbcb", 1));
        System.out.println(findSubstring("abccde", 1));
        System.out.println(findSubstring("abaacb", 2));

        System.out.println("----- 2nd method----");
        System.out.println(findSubstring2("abccde", 1));
        System.out.println(findSubstring2("abaacb", 2));
    }

    // O(26.N)  O(26) for scanning the map (max a-z)
    private static int findSubstring(String str, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        char[] chars = str.toCharArray();

        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<chars.length; i++) {
            charMap.compute(chars[i], (ck, cv) -> cv == null ? 1 : cv + 1);
            while(isInvalid(charMap, k)) {
                int count = charMap.get(chars[left]) - 1;
                charMap.put(chars[left], count);
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    // O(26) as a-z characters are fixed
    private static boolean isInvalid(Map<Character, Integer> charMap, int k) {
        int total = 0;
        int max = Integer.MIN_VALUE;

        for(Character key: charMap.keySet()) {
            max = Math.max(max, charMap.get(key));
            total += charMap.get(key);
        }

        return total - max > k;
    }


    // Another method

    private static int findSubstring2(String str, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        char[] chars = str.toCharArray();
        int maxRepeating = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<chars.length; i++) {
            charMap.compute(chars[i], (ck, cv) -> cv == null ? 1 : cv + 1);
            maxRepeating = Math.max(maxRepeating, charMap.get(chars[i]));

            // is Invalid condition will change
            // we will only look for another answer when maxRepeat is increased
            // if it is decreased we can ignore it
            while(i - left + 1 - maxRepeating > k) {
                int count = charMap.get(chars[left]) - 1;
                charMap.put(chars[left], count);
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
