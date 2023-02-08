package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  Permutation in a String (hard) #
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 */
public class FindPatternPermutation {

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abcd"));
        System.out.println(findPermutation("odicf", "dc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(findPermutation("aaacb", "abc"));
    }

    private static boolean findPermutation(String str, String pattern) {
        if(pattern == null || str == null ||
                pattern.length() > str.length() || pattern.length() <=0) {
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            charMap.put(pattern.charAt(i), charMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;

        while(end < str.length()) {
            if(end < pattern.length()) {
                if(charMap.containsKey(str.charAt(end))) {
                    int count = charMap.get(str.charAt(end)) - 1;
                    charMap.put(str.charAt(end), count);
                }
                end++;
                if(linearScan(charMap)) {
                    return true;
                }
                continue;
            }
            if(charMap.containsKey(str.charAt(start))) {
                int count = charMap.get(str.charAt(start)) + 1;
                charMap.put(str.charAt(start), count);
            }
            if(charMap.containsKey(str.charAt(end))) {
                int count = charMap.get(str.charAt(end)) - 1;
                charMap.put(str.charAt(end), count);
            }
            if(linearScan(charMap)) {
                return true;
            }
            start++;
            end++;
        }

        return false;


    }

    static boolean linearScan(Map<Character, Integer> charMap) {
        for(Character key: charMap.keySet()) {
            if(charMap.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}
