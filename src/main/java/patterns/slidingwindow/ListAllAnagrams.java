package patterns.slidingwindow;

import java.util.*;

public class ListAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findPermutation("cbaebabacd", "abc"));
        System.out.println(findPermutation("ppqp", "pq"));
        System.out.println(findPermutation("abbcabc", "abc"));
    }

    private static List<Integer> findPermutation(String str, String pattern) {
        if(pattern == null || str == null ||
                pattern.length() > str.length() || pattern.length() <=0) {
            return Collections.emptyList();
        }
        List<Integer> count = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            charMap.put(pattern.charAt(i), charMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int left = 0;

        for(int i=0; i<str.length(); i++) {
            if(charMap.containsKey(str.charAt(i))) {
                charMap.put(str.charAt(i), charMap.get(str.charAt(i)) - 1);
            }

            if(i >= pattern.length()) {
                if(charMap.containsKey(str.charAt(left))) {
                    charMap.put(str.charAt(left), charMap.get(str.charAt(left)) + 1);
                }
                left++;
            }

            if(linearScan(charMap)) {
                count.add(left);
            }
        }


        return count;


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
