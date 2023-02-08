package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Smallest Window containing Substring (hard) #
 * Given a string and a pattern, find the smallest substring in
 * the given string which has all the characters of the given pattern.
 *
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 */
public class SmallestWindowContainingSubstring {
    public static void main(String[] args) {
        System.out.println(findSmallestSubstring("aabdec", "abc"));
        System.out.println(findSmallestSubstring("abdabca", "abc"));
        System.out.println(findSmallestSubstring("adcad", "abc"));
    }

    private static String findSmallestSubstring(String str, String pattern) {
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            charMap.put(currChar, charMap.getOrDefault(currChar, 0) + 1);
        }

        int[] indices = new int[2];
        int min = Integer.MAX_VALUE;

        for(int right=0; right<str.length(); right++) {
            if(charMap.containsKey(str.charAt(right))) {
                charMap.put(str.charAt(right), charMap.get(str.charAt(right)) - 1);
            }

            while(containsSubstring(charMap)) {
                if(min > right - left + 1) {
                    min = right - left + 1;
                    indices[0] = left;
                    indices[1] = right;
                }
                char leftChar = str.charAt(left);
                if(charMap.containsKey(leftChar)) {
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
                left++;
            }

        }

        if(min == Integer.MAX_VALUE) {
            return "";
        }
        return str.substring(indices[0], indices[1] + 1);
    }

    static boolean containsSubstring(Map<Character, Integer> charMap) {
        for(Character key: charMap.keySet()) {
            if(charMap.get(key) > 0) {
                return false;
            }
        }

        return true;
    }
}
